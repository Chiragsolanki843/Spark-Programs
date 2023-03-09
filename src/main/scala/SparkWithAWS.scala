/*
import org.apache.spark.{SparkConf, SparkContext}

object SparkWithAWS {

  val inputfile = "s3a://olcbucket/word1.txt"
  val outputfile = "s3a://olcbucket/output/wordcount_output"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    sc.hadoopConfiguration.set("fs.s3a.access.key", "AKIAR4C3FK25ZYTRIYDH")
    sc.hadoopConfiguration.set("fs.s3a.secret.key", "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")

    val wordRDD = sc.textFile(inputfile)
    val words = wordRDD.flatMap(_.split("\\s+"))
    val wc = words.map(w => (w, 1)).reduceByKey(_ + _)
    wc.foreach(println)
    println("Read Successfully")
    wc.saveAsTextFile(outputfile)
    println("Write Successfully")
    println("Program execute successfully")
  }
}
*/
