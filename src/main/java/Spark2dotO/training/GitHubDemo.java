package Spark2dotO.training;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

/**
 * Created by cloudera on 7/26/21.
 */
public class GitHubDemo {
    public static void main(String[] args) throws  Exception {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark = SparkSession.builder().appName("GitHubDemo").config("spark.sql.shuffle.partitions",10).master("local[*]").getOrCreate();
        //it is taking 4 cores if there is * as a result there are 4 partitions in the input df, if we give 1 it is only one partition



        Dataset<Row> df1 = spark.read().format("json").option("inferSchema","true").load("D:\\hadoop\\datasets\\github.json");
       // df1.show()

        System.out.println("---->Explain");
       // df1.groupBy(col("actor.login")).count().orderBy(col("count").desc()).explain();


        System.out.println("---->all Explain's");
       // df1.groupBy(col("actor.login")).count().orderBy(col("count").desc()).explain(true);


       // System.out.println(df1.rdd().getNumPartitions());//which has one partition

        df1.groupBy(col("actor.login")).count().orderBy(col("count").desc()).show();
        //groupBy is wide trasformation
        //orderby is wide trasformation
        //groupByKey(), aggregateByKey(),aggregate(), join(),repartition() are wide trasformations

        Thread.sleep(10000000);

        //we want to find no.of stages

    }
}
