
/* SimpleApp.java */
import org.apache.spark.sql.SparkSession;
        import org.apache.spark.sql.Dataset;

public class FirstClass {
    public static void main(String[] args) {
        String logFile = "D:\\Spark-CCA-175\\categories.txt"; // Should be some file on your system
        SparkSession spark = SparkSession.builder().appName("Simple Application").appName("FirstClass").master("local[1]").config("spark.sql.warehouse.dir","D://hadoop//warehousedir").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        logData.show();
       // long numAs = logData.filter(s -> s.contains("a")).count();
        //long numBs = logData.filter(s -> s.contains("b")).count();

       // System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

       // spark.stop();
    }
}