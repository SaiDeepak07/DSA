package com.example.dsa.june17

fun sortColors(arr: IntArray) {
    var index = 0

    for (i in arr.indices) {
        if (arr[i] == 0) {
            arr[index++] = 0
        }
    }

    for (i in arr.indices) {
        if (arr[i] == 1) {
            arr[index++] = 1
        }
    }

    while (index < arr.size) {
        arr[index++] = 2
    }
}

fun main() {
    val arr = intArrayOf(2, 0, 1, 2, 0, 1, 2, 0)
    sortColors(arr)
    println("Sorted array: ${arr.joinToString(", ")}")
}
