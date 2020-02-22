# Practice 3

## Excersice 4

> The iterative Fibonacci version algorithm with 2 cables was performed in which the function receives an int value and returns an int

```scala
def fib(n:Int ):Int={
    a=0
    b=1
    for (k<- Range(0,n)){
        b=b+a
        a=b-a
    }
    return a
}

fib(10)
```
> Fibonacci iterative version vector uses a function that receives an int data and returns a double, the algorithm makes use of a vector with length n + 1, a for which runs the vector and a condition

## Exercise 5

```scala
def fibo(n :Int):Double={
    if(n<2){
        return n
    }else{
        var vec = new  Array[Double](n+1)
        vec(0) = 0
        vec(1) = 1
        for (k<- Range(2,n+1)){
            vec(k)=vec(k-1)+vec(k-2)
        }
        return vec(n)
    }
    
}

fibo (10)
```


## Exercise 6

> Fibonacci version divide and conquer, use the library scala.math.pow to elvar a number to an exponent. In the algorithm, exponents, a module and tuples are used.

```scala

import scala.math.pow

def fib(n :Int):Double={
    if(n<=0){
        return 0
    }

    var i = n-1
    var aux1 =0.0
    var aux2=1.0

    var ab=(aux2,aux1)
    var cd=(aux1,aux2)

    while(i>0){
        if((i%2)!=0){
            aux1=(cd._2*ab._2)+(cd._1*ab._1)
            aux2=(cd._2*(ab._2+ab._1)+cd._1*ab._2)
            ab=(aux1,aux2)
        }
        aux1=pow(cd._1,2)+pow(cd._2,2)
        aux2=(cd._2*(2*cd._1+cd._2))
        cd=(aux1,aux2)
        i=i/2
    }
    return (ab._1+ab._2)

}

fib(10)
```