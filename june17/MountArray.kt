package com.example.dsa.june17

fun mountArray(arr: IntArray): Boolean {
    if (arr.size < 3) return false

    var inc = false
    var dec = false

    for (i in 1 until arr.size) {
        when {
            arr[i] == arr[i - 1] -> return false
            arr[i] > arr[i - 1] -> {
                if (dec) return false
                inc = true
            }
            arr[i] < arr[i - 1] -> {
                if (!inc) return false
                dec = true
            }
        }
    }

    return inc && dec
}

fun main() {
    val arr1 = intArrayOf(2, 1)
    val arr2 = intArrayOf(1, 2, 3, 4, 5)
    val arr3 = intArrayOf(0, 2, 3, 3, 2, 1)

    println("arr3 is mountain: ${mountArray(arr1)}")
    println("arr4 is mountain: ${mountArray(arr2)}")
    println("arr5 is mountain: ${mountArray(arr3)}")
}
