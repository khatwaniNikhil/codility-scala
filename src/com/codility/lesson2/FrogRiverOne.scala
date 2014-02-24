package com.codility.lesson2

import scala.collection.JavaConversions._

/*A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X. Leaves fall from a tree onto the surface of the river.
You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in minutes.
The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X.
For example, you are given integer X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In minute 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
Write a function:
class Solution { public int solution(int X, int[] A); }
that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
If the frog is never able to jump to the other side of the river, the function should return -1.
For example, given X = 5 and array A such that:
  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above. Assume that:
N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified*/


object FrogRiverOne {
  
  def main(args: Array[String]): Unit = {
    require(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)) == 6)
  }

  def containsSeq1toX(X: Int, A: Array[Int]): Boolean = {
        val seq1toX = Range(1, X+1, 1)
        val sortedASet = A.toSet.toList.sorted
        sortedASet == seq1toX.toList    
    }
    
  def solution(X: Int, A: Array[Int]): Int = {
      (X-1 to A.size-1).find(index => 
                        containsSeq1toX(X, A.slice(0, index+1))).getOrElse(-1)
  }
  
  def solution2(X: Int, A: Array[Int]): Int = {
   var counter = X
   val steps = new Array[Boolean](X+1)

   for(i <- 0 until A.length) {      
      if(steps(A(i)) == false) {
        steps(A(i)) = true
        counter = counter-1
      }
      if(counter == 0) return i      
   }
   return -1;      
}


}