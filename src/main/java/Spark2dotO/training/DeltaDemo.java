package Spark2dotO.training;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.*;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.Metadata;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.spark.sql.functions.when;
import static org.apache.spark.sql.functions.*;
import static org.apache.spark.sql.functions.col;

/**
 * Created by cloudera on 7/29/21.
 */
public class DeltaDemo {

    public static void main(String[] args) throws Exception {

        Logger.getLogger("org").setLevel(Level.ERROR);
        SparkSession session = SparkSession.builder().appName("DeltaDemo")
                .config("spark.sql.shuffle.partitions", 10)//mandatory
                // .enableHiveSupport()
                .master("local[1]").getOrCreate();



        List<Row> cars=new ArrayList<Row>();
        cars.add(RowFactory.create("chevrolet chevelle malibu",18.0,8,307.0,130,3504,12.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("buick skylark 320",15.0,8,350.0,165,3693,11.5,"1970-01-01","USA"));
        cars.add(RowFactory.create("plymouth satellite",18.0,8,318.0,150,3436,11.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("amc rebel sst",16.0,8,304.0,150,3433,12.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("ford torino",17.0,8,302.0,140,3449,10.5,"1970-01-01","USA"));
        cars.add(RowFactory.create ("ford galaxie 500",15.0,8,429.0,198,4341,10.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("chevrolet impala",14.0,8,454.0,220,4354,9.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("plymouth fury iii",14.0,8,440.0,215,4312,8.5,"1970-01-01","USA"));
        cars.add(RowFactory.create("pontiac catalina",14.0,8,455.0,225,4425,10.0,"1970-01-01","USA"));
        cars.add(RowFactory.create("amc ambassador dpl",15.0,8,390.0,190,3850,8.5,"1970-01-01","USA"));

        StructType carsSchema = new StructType(new StructField[]{
                new StructField("Name", DataTypes.StringType, true, Metadata.empty()),
                new StructField("Miles_per_Gallon", DataTypes.DoubleType, true, Metadata.empty()),
                new StructField("Cylinders", DataTypes.IntegerType, true, Metadata.empty()),
                new StructField("Displacement", DataTypes.DoubleType,true, Metadata.empty()),
                new StructField("Horsepower", DataTypes.IntegerType, true, Metadata.empty()),
                new StructField("Weight_in_lbs", DataTypes.IntegerType, true, Metadata.empty()),
                new StructField("Acceleration", DataTypes.DoubleType, true, Metadata.empty()),
                new StructField("Year", DataTypes.StringType, true, Metadata.empty()),
                new StructField("Origin", DataTypes.IntegerType, true, Metadata.empty())
        });

        Dataset<Row> manualCarsDF = session.createDataFrame(cars,carsSchema);

         manualCarsDF.write().format("delta").mode("overwrite").save("D:/hadoop/datasets/output/Cars-delta");

        //manualCarsDF.write().format("csv").mode("overwrite").save("D:/hadoop/datasets/output/Cars-nodelta");

        //spark write is not ACID compliant
        //when there is overwrite mode,
        //case1)
        //With out Delta Lake, day1 can have string column and day2 can have integer col
        //With Delta Lake, you will face run time exception and load fails, which is what we want
        //case2)
        //With out Delta Lake, you will not have your day1 data when there is load failure on day2
        //With Delta Lake, you have your day1 data when there is load failure on day2 (lets say with schema mismatch)
        //because of the json metadata log maintained in output folder

        //Dataset<Row>  mydf =session.read
        //explore delta table//write code here for delta table

    }
}







