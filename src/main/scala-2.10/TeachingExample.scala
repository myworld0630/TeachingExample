import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * Created by zf186001 on 12/16/16.
  */
object TeachingExample {
  // main function
  def main(args: Array[String]) {

    println("Hello World")

    // 檢查是否有設定spark.master的連結url
    var masterURL = "local"
    if (System.getProperty("spark.master") == null || System.getProperty("spark.master").isEmpty())
      masterURL = "local";
    else
      masterURL = System.getProperty("spark.master");

    // 建構SparkConf物件並設定Driver的名稱
    var sparkConf = new SparkConf().setAppName("TeachingExample").setMaster(masterURL)

    // 產生StreamingContext物件來要求根據時間間隔來切割資料串流
    val ssc = new StreamingContext(sparkConf, Seconds(1))
    println("Get Streaming Context")

    //設定 log level
    val rootLogger = Logger.getRootLogger()
    rootLogger.setLevel(Level.ERROR)

    // print for test
    println("TeachingExample Test")

  }

}
