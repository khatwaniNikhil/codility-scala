package com.codility.lesson2

/*A non-empty zero-indexed array A consisting of N integers is given.
A permutation is a sequence containing each element from 1 to N once, and only once.
For example, array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:
    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation.
The goal is to check whether array A is a permutation.
Write a function:
object Solution { def solution(A: Array[Int]): Int }
that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.

Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
*/

object PermCheck {

  def main(args: Array[String]): Unit = {
    require(isPermutation(Array(4,1,3,2)) == 1)
    require(isPermutation(Array(4,1,3)) == 0)
  }

  def isPermutation(A: Array[Int]): Int = {
        val sortedA = A.sorted
        val isPermutation: Boolean = (1 to A.length).forall(i => (sortedA(i-1) == i)) 
        isPermutation match {
            case true => 1
            case false => 0                
        }           
    }
}