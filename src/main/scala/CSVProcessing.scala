/*
import java.io.{File, StringReader, StringWriter}
import com.opencsv.{CSVReader, CSVWriter}
import org.apache.commons.io.FileUtils
import org.apache.hadoop.io.IntWritable
import org.apache.spark.{SparkConf, SparkContext}

object CSVProcessing {
  val inputFile = "D:\\temp.seq\\part-00000"
  val outputFile = "D:\\temp_output"

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    val inputRDD = sc.sequenceFile(inputFile, classOf[org.apache.hadoop.io.Text],
      classOf[IntWritable])

    val yearTempRDD = inputRDD.map { case (year, temp) => {
      println(s"$year $temp")
      //you need to convert them to scala type from hadoop type,else you
      //get serialization issue.it is working in current release
      (year, temp)
    }
    }
    FileUtils.deleteQuietly(new File(outputFile))

    yearTempRDD.saveAsSequenceFile(outputFile)

    println("Program executed Successfully")
  }
}
*/
