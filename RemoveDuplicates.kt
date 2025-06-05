package com.example.dsa

fun removeDuplicates(str: String): String {
    val seen = mutableSetOf<Char>()
    val result = StringBuilder()
    for (char in str) {
        if (char !in seen) {
            seen.add(char)
            result.append(char)
        }
    }
    return result.toString()
}
fun main() {
    val input = "racecar"
    println("Without Duplicates: ${removeDuplicates(input)}")
}
