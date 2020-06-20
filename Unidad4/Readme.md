# Final Project

## I. INTRODUCTION
Machine Learning (ML) automates the construction of
data analysis models, bases its development on systems that
learn from data, identify patterns and make decisions.

### Multilayer Perceptron Classifier
Consists of multiple layers of nodes including the
input layer, hidden layers (also called intermediate layers),
and output layers. Each layer is fully connected to the next
layer in the network.
The input layer consists of neurons that accept the input
values. The output from these neurons is same as the input
predictors. Nodes in the input layer represent the input data.
All other nodes map inputs to outputs by a linear
combination of the inputs with the node’s weights w and
bias b and applying an activation function. This can be
written in matrix form for MLPC with K+1.


### Decision Tree
Decision tree is the most powerful and popular tool for
classification and prediction. A Decision tree is a flowchart
like tree structure, where each internal node denotes a test on
an attribute, each branch represents an outcome of the test,
and each leaf node (terminal node) holds a class label.


### Lineal Support Vector Machine
“Support Vector Machine” (SVM) is a supervised
machine learning algorithm which can be used for both
classification or regression challenges. However, it is
mostly used in classification problems. In the SVM
algorithm, we plot each data item as a point in
n-dimensional space (where n is number of features you
have) with the value of each feature being the value of a
particular coordinate. Then, we perform classification by
finding the hyper-plane that differentiates the two classes
very well (look at the below snapshot).

### Logistic Regression
Logistic regression is the appropriate regression analysis to
conduct when the dependent variable is dichotomous
(binary). Like all regression analyses, the logistic regression
is a predictive analysis. Logistic regression is used to
describe data and to explain the relationship between one
dependent binary variable and one or more nominal, ordinal,
interval or ratio-level independent variables.

**Performance**

| |Used memory MB|Seconds|
|---|---|----|-------|
|SVC |464.87 |15.5|
|Logistic Regression| 418.77 |7.1|
|Decision Three |373.89 | 11.9|
|Multilayer perceptron| 598.21 |22.3|

**Accuracy**
| |Accuracy|Error|
|---|---|---|
|SVC| 0.885| 0.114|
|Logistic Regression| 0.884| 0.115|
|Decision Three| 0.891| 0.108|
|Multilayer perceptron| 0.882 |0.117|

### CONCLUSIONS
After looking at the results of the different types of
classification algorithms with the banck-full dataset, we can
see that on average decision trees was the one that best
classified this dataset consuming less memory than the
other algorithms with an average time of 11.9 seconds. and
an accuracy of 89.1%. The second best algorithm that we
looked at was SVC, even though it uses a little more
memory, we get an effectiveness a little under decision
trees with 88.5% accuracy and with an average time of 15.5
seconds, taking into account that SVC could improve its
results or make them worse using different kernels.