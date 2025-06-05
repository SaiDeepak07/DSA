package com.example.dsa

fun mostFrequentChar(str: String): Char? {
    val freqMap = countCharOccurrences(str)
    return freqMap.maxByOrNull { it.value }?.key
}

fun main() {
    val input = "racecar"
    println("Most Frequent Char: ${mostFrequentChar(input)}")
}
