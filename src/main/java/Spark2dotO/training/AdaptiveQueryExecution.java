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
public class AdaptiveQueryExecution {
    public static void main(String[] args) throws  Exception{


        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark = SparkSession.builder().appName("AQE")

                .config("spark.sql.adaptive.enabled",true)//AQE is enabled
                .config("spark.sql.shuffle.partitions",20)//even after giving 20 we get 1 partition because AQE
                .master("local[1]").getOrCreate();

        spark.conf().set("spark.sql.autoBroadcastJoinThreshold", "-1");
        //as our file sizes are less (to understand other joins and we dont want broadcast join to happen, so we are making the threshold to 0)

        Dataset<Row> usersDF = spark.read().format("csv").option("header",true).option("inferSchema","true")
                .load("file:///D:/hadoop/datasets/usersIn.csv").toDF("uid","login","email","user_state");
        Dataset<Row> ordersDF = spark.read().format("csv").option("header",true).option("inferSchema","true")
                .load("file:///D:/hadoop/datasets/ordersIn.csv").toDF("transaction_id","quantity","user_id","amount","state","items");


        //Join which will choose "shuffle sort merge join"
        usersDF.join(ordersDF,usersDF.col("uid").equalTo(ordersDF.col("user_id"))).show();

        Thread.sleep(10000000);
    }
}
