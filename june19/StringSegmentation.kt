package com.example.dsa.june19

fun stringSegmentation(inputString: String, dictionary: Set<String>): Boolean {
    val canSegment = BooleanArray(inputString.length + 1)
    canSegment[0] = true

    for (endIndex in 1..inputString.length) {
        for (startIndex in 0 until endIndex) {
            val word = inputString.substring(startIndex, endIndex)
            if (canSegment[startIndex] && word in dictionary) {
                canSegment[endIndex] = true
                break
            }
        }
    }

    return canSegment[inputString.length]
}

fun main() {
    val inputString = "applepenapple"
    val dictionaryWords = setOf("apple", "pen")

    val result = stringSegmentation(inputString, dictionaryWords)
    println(result)
}
