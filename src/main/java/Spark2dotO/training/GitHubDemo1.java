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
public class GitHubDemo1 {
    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession session = SparkSession.builder().appName("GitHubDemo")
                .config("spark.sql.shuffle.partitions",10)//mandatory
                .master("local[1]").getOrCreate();

        Dataset<Row> githubDF = session.read()
                .format("json")
                .load("D:/hadoop/datasets/github.json");

       // System.out.println((((String) githubDF.rdd())));

        githubDF.groupBy(col("actor.login")).count().orderBy(col("count").desc()).show();

        Thread.sleep(100000000);

    }

}
