package com.codility.lesson3

object GenomicRangeQuery {

  def main(args: Array[String]): Unit = {
    require(solution("GACACCATA", Array(0, 0, 4, 7), Array(8, 2, 5, 7)).deep == Array(1, 1, 2, 4).deep)
  }
  
  def solution(S: String, P: Array[Int], Q: Array[Int]): Array[Int] = {
    findMinNucleotideForGivenDNA(S, P, Q)   
 }

  def findMinNucleotideForGivenDNA(S: String, P: Array[Int], Q: Array[Int]): Array[Int] = {
	val fun = (x: Char) => x match {
        case 'A' => 1
        case 'C' => 2
        case 'G' => 3
        case 'T' => 4    
    }
    val dnaNumeric = S.map(fun(_))
    
    for {
      i <- Range(0, P.size).toArray
      val (start,end) = (P(i), Q(i)) 
      val dnaSubSet = dnaNumeric.slice(start, end+1).toArray
    } yield (dnaSubSet.sortWith((a,b) => a < b).head)
  }
}