package Spark2dotO.training;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

/**
 * Created by cloudera on 7/27/21.
 */
public class JoinDemoWithOutShuffle {
    public static void main(String[] args) throws  Exception{
        // file:///home/cloudera/Desktop/SW/Datasets/usersIn

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark =
                SparkSession.builder().appName("JoinDemoWithOutShuffle")//.enableHiveSupport()
                        .config("spark.sql.shuffle.partitions", 10).master("local[1]").getOrCreate();

        spark.conf().set("spark.sql.autoBroadcastJoinThreshold", "-1");
        //if there is shuffle involved by default no.of partitions is 200, so always change the no. to 10 or any

        //as our file sizes are less (to understand other joins and we dont want broadcast join to happen, so we are making the threshold to 0)

        Dataset<Row> usersDF =
                spark.read().format("csv").option("header",true).option("inferSchema","true")

                        .load("file:///D:/hadoop/datasets/usersIn.csv").toDF("uid","login","email","user_state");
        Dataset<Row> ordersDF =
                spark.read().format("csv").option("header",true).option("inferSchema","true")

                        .load("file:///D:/hadoop/datasets/ordersIn.csv").toDF("transaction_id","quantity","user_id","amount","state","items");
        //usersDF.show();
        //ordersDF.show();

        //usersDF.printSchema();
        //ordersDF.printSchema();

        //Join which will choose "shuffle sort merge join"
        //usersDF.join(ordersDF,usersDF.col("uid").equalTo(ordersDF.col("user_id"))).show();
        //usersDF.join(ordersDF,usersDF.col("uid").equalTo(ordersDF.col("user_id"))).explain(true);


        //SQL-->(last id)-->http://localhost:4041/SQL/execution/?id=2----> shuffle sort merge join
        //JOB-->(last job id)-->DAG visualization-->http://localhost:4041/jobs/job/?id=7 --> you are seeing 2 shuffle's happing on two large files
        //in DAG there are also skipped steps which are in gray color

        // Question: we have called for a join on two large files so shuffle sort merge join has come into picture when we used inner join
        //Answer: We want to optimize the shuffle happening on these large files. So for these large file use hive bucketing concept to      remove the shuffle

                //Hive concept ->
                //1)if Cardinality is high ->use bucketing
                //2)if Cardinality is low(key is different for each row) ->use partitioning

        //No.of buckets for these has to be same and key has to be same as we want to join them later
        //now after bucketing read the bucketed table from hive to dataframe and apply join
        //That means we are joining two datasets which are pre-sorted
        //Now the spark will still go and choose the shuffle merge sort but in the same stage(shuffle happens but in same stage because we have pre-sorted data)

        //try caching on this

        //we are running it on local mode, which means it is using spark-warehouse folder where it creates hive tables in local and we have not used enableHiveSupport()
        usersDF.orderBy(col("uid"))
                .write().format("parquet")
                .bucketBy(8,"uid")
                .mode(SaveMode.Overwrite)
                .saveAsTable("usersDFBucketTbl");

        ordersDF.orderBy(col("user_id"))
                .write().format("parquet")
                .bucketBy(8,"user_id")
                .saveAsTable("ordersDFBucketTbl");

        Dataset<Row> usersBucketOrderDF = spark.table("usersDFBucketTbl");
        Dataset<Row> ordersBucketOrderDF = spark.table("ordersDFBucketTbl");

        //usersBucketOrderDF.cache();//way of caching the dataset in spark executor
        //ordersBucketOrderDF.cache();//you cache the dataset or you cache the hive table it is the same


        //way of caching the hive table in spark in-memory(or in executor)
        //Dataset<Row> usersBucketOrderCached = spark.sql("CACHE table usersDFBucketTbl");
        //Dataset<Row> ordersBucketOrderCached = spark.sql("CACHE table ordersDFBucketTbl");
        //to uncache:
        //spark.sql("uncache table usersDFBucketTbl")
        //spark.catalog.uncacheTable("usersDFBucketTbl")
        //to persist dataframe:
        //df.persist()--> data on disk is always serialized
        //to unpersist dataframe:
        //spark.sql("df.unpersist()")



                        //tables are cached here in the hive tables //dataframes are not cached
                        usersBucketOrderDF.join(ordersBucketOrderDF,usersBucketOrderDF.col("uid").equalTo(ordersBucketOrderDF.col("user_id"))).show(true);

        //usersBucketOrderCached.join(ordersBucketOrderCached,usersBucketOrderCached.col("uid").equalTo(ordersBucketOrderCached.col("user_id"))).show(false);


        //try caching also -->use cache not persist
        Thread.sleep(10000000);
    }
}
