package Spark2dotO.training;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class JoinDemoWithShuffle {
    public static void main(String[] args) throws  Exception{
        // file:///home/cloudera/Desktop/SW/Datasets/usersIn

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark =
                SparkSession.builder().appName("JoinDemoWithShuffle")
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


        //Join which will choose "shuffle sort merge join"
        usersDF.join(ordersDF,usersDF.col("uid").equalTo(ordersDF.col("user_id"))).show();
        //usersDF.join(ordersDF,usersDF.col("uid").equalTo(ordersDF.col("user_id"))).explain(true);


        //SQL-->(last id)-->http://localhost:4041/SQL/execution/?id=2----> shuffle sort merge join
        //JOB-->(last job id)-->DAG visualization-->http://localhost:4041/jobs/job/?id=7 --> you are seeing 2 shuffle's happing on two large files
        //in DAG there are also skipped steps which are in gray color

        Thread.sleep(10000000);
    }
}
