package com.example.dsa.june17

fun moveZerosToEnd(arr: IntArray): IntArray {
    val nonZeros = arr.filter { it != 0 }
    val zeros = arr.filter { it == 0 }
    return (nonZeros + zeros).toIntArray()
}

fun main() {
    val array = intArrayOf(0, 1, 0, 3, 12)
    val result = moveZerosToEnd(array)
    println("After moving zeros: ${result.joinToString(", ")}")
}
