
# Test

## Description of the problem

Given a square matrix, calculate the absolute difference between the sums of your diagonals.

arr = [[11,2,4], [4,5,6], [10,3, -12]]

diagonal_1 = 11 + 5 - 12 = 4
diagonal_2 = 4 + 5 + 10 = 19

Absolute Address = | 4 - 19 | = 15

## Solution

We solve the problem with tuples, the function receives a variable called arr, which is a tuple of tuples with data type Int.
We declare two tuple variables called Diagonal_1 and Diagonal_2, to which we give the diagonals.
With the function ** Math.abs () ** we make the difference of the diagonals and the absolute result and finally we return 15 as a result.

``` scala

def DiagonalDifference (arr: ((Int, Int, Int), (Int, Int, Int), (Int, Int, Int))): Int = {

var diagonal_1 = (arr._1._1 + arr._2._2 + arr._3._3)
var diagonal_2 = (arr._1._3 + arr._2._2 + arr._3._1)
var differenceadsolute = Math.abs (diagonal_1-diagonal_2)
return difference
}

Diagonal difference (arr = ((11,2,4), (4,5,6), (10,8, -12)))

```