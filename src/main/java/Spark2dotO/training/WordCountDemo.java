package Spark2dotO.training;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by cloudera on 7/26/21.
 */
public class WordCountDemo {
    public static void main(String[] args)  throws  Exception{
        SparkConf conf = new SparkConf().setAppName("airports").setMaster("local[1]");

        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> lines = sc.textFile("D:/hadoop/datasets/word_count.text");
        JavaRDD<String> words = lines.flatMap(line -> Arrays.asList(line.split(" ")).iterator());

        words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String,Integer> call(String s) {
                return new Tuple2<String,Integer>(s, 1);
            }
        }).reduceByKey((x,y) -> (int)x+(int)y).collect()
                .forEach(x-> System.out.println(x._1+"value-->"+x._2));


        Thread.sleep(10000000);
    }
}
