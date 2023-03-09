/*
import org.apache.spark.{SparkConf, SparkContext}

object JoinDemo {

 // def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    val customerDetailsFile = "D:\\customerDetails.txt"
    val customerBalanceFile = "D:\\customerBalance.txt"

    //loads the file into RDD
    val detailsRDD = sc.textFile(customerDetailsFile)
    val balanceRDD = sc.textFile(customerBalanceFile)

    detailsRDD.collect().foreach(println)
    balanceRDD.collect().foreach(println)

    val idDetailsValue = detailsRDD.map(row => {
      val data = row.split(",")
      (data(0), data(1) + " " + data(2))
    })
    idDetailsValue.foreach(println)

    val idBalanceKeyValue = balanceRDD.map(row => {
      val data = row.split(",")
      (data(0), data(1))
    })
    idBalanceKeyValue.foreach(println)

    val joined = idDetailsValue.join(idBalanceKeyValue).sortByKey(false)
    joined.foreach(println)

    val finalOutput = joined.map { case (accno, (name, amount)) => (accno, name, amount) }
    finalOutput.collect.foreach(println)


    //we can perform LeftOuter,RightOuter,Fullouter join and inner join using the below concept
    val joined2 = idDetailsValue.fullOuterJoin(idBalanceKeyValue)
    joined2.collect.foreach(println)

    val pairedByBalance = finalOutput.map {
      case (accno, name, amount) =>
        (amount.toFloat, (accno, name))
      //If you don't write amount.float and just write amount, then the amount will be
      //returned as a String,and when you try to sort it, it will sort the data lexically.
    }
    pairedByBalance.foreach(println)
    //sort pairedByBalance in descending order of the key

    val sortedByBalance = pairedByBalance.sortByKey(false)
    sortedByBalance.foreach(println)


    //get the first Element from the list
    //    val highestBalance=sortedByBalance.first()
    //   println(highestBalance)


    //Convert the structure back to what we used to have
    //val highestBalance = sortedByBalance.first()
    //println(highestBalance._2 + " " + highestBalance._1)

    //Access the element inside the tuple
    val highestBalance = sortedByBalance.first()
    println(highestBalance._2._1 + " " + highestBalance._2._2 + " " + highestBalance._1)

    //Top 3 Customers with Max Balance
    // val top3BalanceCustomer=sortedByBalance.top(3)
    //top3BalanceCustomer.foreach(println)

    val top3BalanceCustomer=sortedByBalance.top(3)
    val formatttedTop3=top3BalanceCustomer.map{
      case (balance,(accno,name))=>(accno,name,balance)
    }
    formatttedTop3.foreach(println)

    //Find out total of all the account Balance
    val onlyBalanceRDD=idBalanceKeyValue.map{case(_,balance)=>balance.toFloat}
    println("TOtal Balance : "+onlyBalanceRDD.sum())

    //Using Accumulator
    val balanceTotal=sc.longAccumulator("Account Balance Total")
    idBalanceKeyValue.foreach(data=>balanceTotal.add(data._2.toInt))
    println("Using Accumulator "+balanceTotal.value)
  }*/
