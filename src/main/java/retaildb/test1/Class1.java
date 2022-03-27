package retaildb.test1;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;


public class Class1 {
    public static void main(String[] args) throws Exception{
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark = SparkSession.builder().appName("GitHubDemo").config("spark.sql.shuffle.partitions",10).master("local[*]").getOrCreate();



        Dataset<Row>  dataFile = spark.read().format("csv").option("header","true").load("D:/Spark-CCA-175/orders.txt");
        /*dataFile.write().mode("overwrite").format("com.databricks.spark.avro").save("D:/Spark-CCA-175/output/avro/orders.avro");
        Dataset<Row> avroDataFile2 = spark.read().format("com.databricks.spark.avro").option("header","true").load("D:/Spark-CCA-175/output/avro/orders.avro");

        avroDataFile2.select("order_id","order_status").write().mode("overwrite").option("compression","gzip").format("parquet").save("D:/Spark-CCA-175/output/parquet2");

        spark.read().format("parquet").option("header","true").load("D:/Spark-CCA-175/output/parquet2").show();*/
        //dataFile.orderBy(col("order_status")).show();

        Dataset<Row>   dataFile2= dataFile.limit(5).repartition(8);
        dataFile2 .write().mode("overwrite").format("csv").option("compression", "snappy").save("D:/Spark-CCA-175/output/csv/orders.csv");

        System.out.println(dataFile2.rdd().getNumPartitions());
        Thread.sleep(10000000);

    }
}
