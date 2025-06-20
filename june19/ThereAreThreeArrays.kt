package com.example.dsa.june19

fun thereAreThreeArrays(A: ArrayList<Int>, B: ArrayList<Int>, C: ArrayList<Int>): Int {
    A.sort()
    B.sort()
    C.sort()

    var i = 0
    var j = 0
    var k = 0
    var minDiff = Int.MAX_VALUE

    while (i < A.size && j < B.size && k < C.size) {
        val a = A[i]
        val b = B[j]
        val c = C[k]

        // Manual way to find min, mid, max
        val list = listOf(a, b, c).sorted()
        val minVal = list[0]
        val maxVal = list[2]
        val diff = maxVal - minVal

        if (diff < minDiff) {
            minDiff = diff
        }

        // Move the pointer pointing to the smallest value
        when (minVal) {
            a -> i++
            b -> j++
            c -> k++
        }
    }

    return minDiff
}

fun main() {
    val A = arrayListOf(5, 8, 10, 15)
    val B = arrayListOf(89, 15, 6, 9, 78)
    val C = arrayListOf(2, 3, 6, 8, 8, 10, 6)

    val result = thereAreThreeArrays(A, B, C)
    println(result)
}
