import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/karen/Documentos/DatosMasivosClase/BigData/Spark_DataFrame/P2-Mispriced-Diamonds.csv")


df.printSchema()
import spark.implicits._
// #1 Average in a data set (price)
df.select(avg("price")).show()

//#2  perform the sum over a data set
df.select(sum("price")).show()

//#3 identify the minimum value on a data set
df.select(min("price"),max ("price")).show()

//#4 Identify the maximum value in a data set
df.select(max("price")).show()

//#5 Shows an example that calculates the mean and maximum value of the subset of data grouped by last name
df.groupBy(df.col("carat")).agg(avg("price"), max("price")).show()

//#6 Shows an example that calculates the correlation over a data set
df.stat.corr("carat", "price")

//#7 Example that calculates covariance in a data set
df.stat.cov("carat", "price")

//#8  Show all Data Frame
df.show()

//#9 Show the names of the DataFrame columns
df.columns
