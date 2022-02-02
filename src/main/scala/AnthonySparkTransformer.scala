// spark-submit --class AnthonySparkTransformer AnthonySparkTransformer-1.0-SNAPSHOT-fat.jar
// export HADOOP_CONF_DIR=$HADOOP_HOME/etc/hadoop
// export YARN_CONF_DIR=$HADOOP_HOME/etc/hadoop
// spark-submit --class AnthonySparkTransformer --master yarn --deploy-mode cluster AnthonySparkScalaProject-1.0-SNAPSHOT-fat.jar
// D:\Projects\AnthonySparkScalaProject\target>jar -tf AnthonySparkScalaProject-1.0-SNAPSHOT-fat.jar > hello
// https://mkyong.com/maven/create-a-fat-jar-file-maven-shade-plugin/

import org.apache.spark.sql.SparkSession

object AnthonySparkTransformer {
  def main(args: Array[String]): Unit = {
    // Create a Spark Session
    // For Windows
    //System.setProperty("hadoop.home.dir", "C:\\winutils")
    // .config("spark.sql.warehouse.dir",warehouseLocation).enableHiveSupport()

    val spark = SparkSession
      .builder
      .appName("HelloSpark")
      .config("spark.master", "local")
      .enableHiveSupport()
      .getOrCreate()

    println("Created Spark Session")
    val sampleSeq = Seq((1,"spark"),(2,"Big Data"))

    val df = spark.createDataFrame(sampleSeq).toDF("course id", "course name")
    df.show()



  }
}
