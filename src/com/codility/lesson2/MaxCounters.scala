package com.codility.lesson2

/*You are given N counters, initially set to 0, and you have two possible operations on them:
increase(X) - counter X is increased by 1,
max_counter - all counters are set to the maximum value of any counter.
A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:
if A[K] = X, such that 1 = X = N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max_counter.
For example, given integer N = 5 and array A such that:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:
    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.
Write a function:
object Solution { def solution(N: Int, A: Array[Int]): Array[Int] }
that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.
The sequence should be returned as:
a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:
    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.
*/

object Solution {
    def increaseByOne(counter: Int, A: Array[Int]) = {
        A(counter-1) = A(counter-1) + 1          
    }    
    
    def max_counter(A: Array[Int]) = {
          Array.fill(A.size)(A.max)       
    }    
    
    def solution(N: Int, A: Array[Int]): Array[Int] = {
        var result = new Array[Int] (N)
        for(i <- A) {
            if(i >=1 && i <= N) increaseByOne(i, result)
            if(i == N+1) result = max_counter(result)    
        }       
        result   
    }
}

object MaxCounters {

  def main(args: Array[String]): Unit = {
    require(solution(5, Array(3, 4, 4, 6, 1, 4, 4)).deep == Array(3, 2, 2, 4, 2).deep)
  }
  
  def increaseByOne(counter: Int, A: Array[Int]) = {
        A(counter-1) = A(counter-1) + 1          
  }    
    
  def max_counter(A: Array[Int]) = {
    Array.fill(A.size)(A.max)       
  }    
    
  def solution(N: Int, A: Array[Int]): Array[Int] = {
    var result: Array[Int] = new Array[Int] (N)
    for(i <- A) {
        if(i >=1 && i <= N) increaseByOne(i, result)
        if(i == N+1) result = max_counter(result)    
    }       
    result   
  }
}