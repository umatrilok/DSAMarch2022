package retaildb.test2;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.sum;

public class Class1 {
    public static void main(String[] args) {
        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession spark = SparkSession.builder().appName("GitHubDemo").config("spark.sql.shuffle.partitions",10).master("local[*]").getOrCreate();



        Dataset<Row>  order_items = spark.read().format("csv").option("header",true).load("D:/Spark-CCA-175/order_items.txt").groupBy(col("Order_item_order_id")).agg(sum(col("Order_item_subtotal")).as("amt")).filter("amt > 200");


        Dataset<Row>  cust = spark.read().format("csv").option("header",true).load("D:/Spark-CCA-175/customers.txt");
        Dataset<Row>  orders = spark.read().format("csv").option("header",true).load("D:/Spark-CCA-175/orders.txt");


        Dataset<Row>  cust_orders=cust.join(orders,col("customer_id" ).equalTo(orders.col("order_customer_id")));


        //Dataset<Row>  order_items_join_cust_orders= cust_orders.join(order_items,$"order_id" === $"Order_item_order_id");

        //order_items_join_cust_orders.select($"customer_firstname".as("fname"),$"customer_lastname".as("lname"),$"customer_city".as("city"),$"amt".as("price")).map(x=>x.mkString("\t")).write.mode("overwrite").format("text").save("home/hdoop/Desktop/retail_db/output/T2/Q1/");

    }
}
