package com.example.dsa

fun countCharOccurrences(str: String): Map<Char, Int> {
    val map = mutableMapOf<Char, Int>()
    for (char in str) {
        map[char] = map.getOrDefault(char, 0) + 1
    }
    return map
}

fun main() {
    val input = "racecar"
    println("Character Occurrences: ${countCharOccurrences(input)}")
}
