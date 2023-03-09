import org.apache.spark.sql.SparkSession

object SparkSQLDemo1 {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession
      .builder()
      .master("local")
      .appName("SparkAndHive")
      .config("spark.sql.warehouse.dir", "/tmp/spark-warehouse")
      .enableHiveSupport()
      .getOrCreate()

    val configMap = sparkSession.conf.getAll
    configMap.foreach(println)

    val empDF = sparkSession.read.json("D:\\data.json")
    empDF.cache()
    empDF.show()

    empDF.createOrReplaceTempView("employee")

    val resultDF = sparkSession.sql("SELECT name,email[0],communication.phones FROM employee")

    resultDF.show()

    sparkSession.sql("DROP TABLE IF EXISTS employee_details")

    resultDF.write.saveAsTable("employee_details")

    val resultsHiveDF = sparkSession.sql("SELECT * FROM employee_details")

    resultsHiveDF.show(10)

  }
}
