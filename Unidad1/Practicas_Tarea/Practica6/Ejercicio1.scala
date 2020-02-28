import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("/home/eduardo/Escritorio/semestre_9/BigData/Unidad1/Practicas_Tarea/Practica6/Sales.csv")


df.printSchema()

df.show()

//1.creturns the approximate number of distinct items in a group.
df.select(approx_count_distinct("Sales")).show()

//2. returns the average of the values in a group.
df.select(avg("Sales")).show()
//3. returns a list of objects with duplicates.
df.select(collect_list("Company")).show()
//4. returns the number of items in a group.
df.select(count("Sales")).show()

//5. returns the first value of a column in a group.
df.select(first("Person")).show()

// 6. returns the kurtosis of the values in a group.
df.select(kurtosis("Sales")).show()

//7. returns the last value of the column in a group.
df.select(last("Person")).show()
// 8. returns the population standard deviation of the expression in a group.
df.select(stddev_pop("Sales")).show()

//9. returns the skewness of the values in a group.
df.select(skewness("Sales")).show()

// 10 returns the population variance of the values in a group.
df.select(var_pop("Sales")).show()

