// We import our libraries to use ml
// pipeline to process the data and join it
// GBT for classification and modeling
// Feature to index our data
package org.apache.spark.examples.ml
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
// $example off$
import org.apache.spark.sql.SparkSession


    val spark = SparkSession.builder.appName("GradientBoostedTreeClassifierExample").getOrCreate()

    // We load our dataset from mlib
    val data = spark.read.format("libsvm").load("/home/eduardo/Escritorio/semestre_9/BigData/Unidad2/Practicas_Tareas/Data/sample_libsvm_data.txt")

    // We index our labels to work them
    val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
    
    // Automatically indentifies categories and indexes them
    val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

    // We divide our data set into training data and test or testing data
    // 70% for training and% 30 for testing.
    val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

    // Train a GBT model.
    val gbt = new GBTClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setMaxIter(10).setFeatureSubsetStrategy("auto")

    // Convert indexed labels back to original labels.
    val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
    
    // we join our gbt model our indexed labels through Pipeline
    val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))
    
    // We train our pipeline using training data and the fit function
    val model = pipeline.fit(trainingData)

    // We create our predictions transforming our data
    val predictions = model.transform(testData)

    // select some test columns and display them.
    predictions.select("predictedLabel", "label", "features").show(5)

    // We select our predictions and true labels as well as the margin of error obtained.
    val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")

    // Evaluations and we get the percentage of the prediction
    val accuracy = evaluator.evaluate(predictions)
    println(s"Test Error = ${1.0 - accuracy}")

    // Print result of Trees using GBTs
    val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
    println(s"Learned classification GBT model:\n ${gbtModel.toDebugString}")
  