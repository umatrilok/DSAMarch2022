package Spark2dotO.training;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.catalyst.plans.logical.Except;

import static org.apache.spark.sql.functions.split;
import static org.apache.spark.sql.functions.col;


public class PredicatePushDownDemo {
    public static void main(String[] args) throws Exception {
                Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark = SparkSession.builder().appName("PredicatePushDown")
                .master("local[1]").getOrCreate();

        Dataset<Row> wikiDF = spark.read()
                .format("text")
                .option("inferSchema", "true")
                .load("D:/hadoop/datasets/wiki-pageviews.txt");

        Dataset<Row> schemaWikiDF = wikiDF.withColumn("domain", split(col("value"), "\\s+").getItem(0))
                .withColumn("pageName", split(col("value"), "\\s+").getItem(1))
                .withColumn("viewCount", split(col("value"), "\\s+").getItem(2))
                .withColumn("size", split(col("value"), "\\s+").getItem(3));

        schemaWikiDF.show();
        System.out.println("Explain Plan:----->");

        schemaWikiDF.orderBy(col("viewCount").desc())
                .filter(col("domain").startsWith("en")).explain();

        System.out.println("All Explain Plan's:----->");


        schemaWikiDF.orderBy(col("viewCount").desc())
                .filter(col("domain").startsWith("en")).explain(true);

        schemaWikiDF.orderBy(col("viewCount").desc())
                .filter(col("domain").startsWith("en")).show();

        Thread.sleep(10000000);

    }

}
