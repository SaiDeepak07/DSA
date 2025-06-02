package com.example.dsa

fun main() {
    // Q1
    val arr11 = intArrayOf(10, 50, 20, 30, 70, 80, 40)
    println("Second Largest: ${secondLargest(arr11)}")

    // Q2
    println("Second Smallest: ${secondSmallest(arr11)}")

    // Q3
    val a13 = intArrayOf(10, 50, 20, 30, 70, 80, 40)
    val b13 = intArrayOf(25, 75, 5, 25)
    println("Zigzag Merge: ${mergeZigzag(a13, b13).toList()}")

    // Q4
    val sorted1 = intArrayOf(10, 28, 50, 75, 80, 95, 100)
    val sorted2 = intArrayOf(35, 60, 70, 78)
    println("Sorted Merge: ${mergeSorted(sorted1, sorted2).toList()}")

    // Q5
    val arr15 = intArrayOf(1, 2, 3, 4, 5)
    println("Left Rotated: ${rotateLeft(arr15.copyOf(), 2).toList()}")

    // Q6
    println("Right Rotated: ${rotateRight(arr15.copyOf(), 2).toList()}")

    // Q7
    val arr17 = intArrayOf(2, -3, 1, 0, 5, -1, -2)
    println("First pair with sum zero: ${firstPairSumZero(arr17)?.toList()}")

    // Q8
    val arr18 = intArrayOf(1, 3, 2, 2, 4, 0, 5)
    println("All pairs with sum 4: ${allPairsWithSum(arr18, 4)}")

    // Q9
    val arr19 = intArrayOf(3, 9, 5, 1, 7)
    println("Max: ${arr19.maxOrNull()}")

    // Q10
    println("Min: ${arr19.minOrNull()}")
}

fun secondLargest(arr: IntArray): Int? {
    var max = Int.MIN_VALUE
    var second = Int.MIN_VALUE
    for (num in arr) {
        if (num > max) {
            second = max
            max = num
        } else if (num > second && num != max) {
            second = num
        }
    }
    return if (second == Int.MIN_VALUE) null else second
}
// Time: O(n), Space: O(1)

fun secondSmallest(arr: IntArray): Int? {
    var min = Int.MAX_VALUE
    var second = Int.MAX_VALUE
    for (num in arr) {
        if (num < min) {
            second = min
            min = num
        } else if (num < second && num != min) {
            second = num
        }
    }
    return if (second == Int.MAX_VALUE) null else second
}
// Time: O(n), Space: O(1)

fun mergeZigzag(a: IntArray, b: IntArray): IntArray {
    val result = mutableListOf<Int>()
    val minLength = minOf(a.size, b.size)
    for (i in 0 until minLength) {
        result.add(a[i])
        result.add(b[i])
    }
    result.addAll(a.drop(minLength))
    result.addAll(b.drop(minLength))
    return result.toIntArray()
}
// Time: O(n + m), Space: O(n + m)

fun mergeSorted(a: IntArray, b: IntArray): IntArray {
    val result = IntArray(a.size + b.size)
    var i = 0; var j = 0; var k = 0
    while (i < a.size && j < b.size) {
        result[k++] = if (a[i] < b[j]) a[i++] else b[j++]
    }
    while (i < a.size) result[k++] = a[i++]
    while (j < b.size) result[k++] = b[j++]
    return result
}
// Time: O(n + m), Space: O(n + m)

fun rotateLeft(arr: IntArray, n: Int): IntArray {
    val shift = n % arr.size
    return (arr.drop(shift) + arr.take(shift)).toIntArray()
}
// Time: O(n), Space: O(n)

fun rotateRight(arr: IntArray, n: Int): IntArray {
    val shift = n % arr.size
    return (arr.takeLast(shift) + arr.dropLast(shift)).toIntArray()
}

// Time: O(n), Space: O(n)

fun firstPairSumZero(arr: IntArray): Pair<Int, Int>? {
    val seen = mutableSetOf<Int>()
    for (num in arr) {
        if (-num in seen) return Pair(num, -num)
        seen.add(num)
    }
    return null
}
// Time: O(n), Space: O(n)

fun allPairsWithSum(arr: IntArray, target: Int): List<Pair<Int, Int>> {
    val seen = mutableMapOf<Int, Int>()
    val result = mutableListOf<Pair<Int, Int>>()
    for (num in arr) {
        val complement = target - num
        if (seen.getOrDefault(complement, 0) > 0) {
            result.add(Pair(num, complement))
            seen[complement] = seen[complement]!! - 1
        } else {
            seen[num] = seen.getOrDefault(num, 0) + 1
        }
    }
    return result
}
// Time: O(n), Space: O(n)
