//1
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
//2
val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/karen/Documentos/DatosMasivosClase/BigData/Spark_DataFrame/Netflix_2011_2016.csv")

//3 
df.columns

//4
df.printSchema()

//5
df.take(5)

//6
df.describe().show

//7
 val df2 =df.withColumn("HV_Ratio", df("High")/df("Volume"))
 df2.show

//8
val a =df.select(max("Close")).filter("Date").show()
a.show
//9
/*Close en la bolsa de valores es el valor total de las acciones con la que cerro ese dia*/

//10
df.select(max("Volume"),min("Volume")).show()

//11.a
val preciosmenor = df.filter($"Close" < 600).count()
//11.b
val tiempo = df.filter($"High" > 500).count()
val tiempo1= tiempo * .100

//11.c
df.select(corr("High", "Volume").alias("correlacion")).show()

//11.d
val dfmins = df.groupBy(month("Date")).max()
dfmins.select($"Date", $"max(High)").show()

df.groupBy(month(df("Date")).alias("Month")).avg("Close").sort(asc("Month")).show()
//11.e
df.select(avg("Close").alias("Promedio")).show()