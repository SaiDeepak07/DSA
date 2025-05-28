package com.example.dsa
fun moveOnesToEnd(arr: MutableList<Int>) {
    var i = 0
    for (j in arr.indices) {
        if (arr[j] != 1) {
            arr[i] = arr[j]
            i++
        }
    }
    for (k in i until arr.size) arr[k] = 1
}
// Time: O(n), Space: O(1)

fun longestCommonPrefix(strs: List<String>): String {
    if (strs.isEmpty()) return ""
    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (!strs[i].startsWith(prefix)) {
            prefix = prefix.dropLast(1)
            if (prefix.isEmpty()) return ""
        }
    }
    return prefix
}
// Time: O(n * m), Space: O(1)

fun reorderPickupDelivery(arr: MutableList<Int>): Pair<Int, Int> {
    var i = 0
    var pickup = 0
    var delivery = 0
    for (j in arr.indices) {
        if (arr[j] == 1) {
            arr[i++] = 1
            pickup++
        } else delivery++
    }
    for (k in i until arr.size) arr[k] = 0
    return Pair(pickup, delivery)
}
// Time: O(n), Space: O(1)

fun areAllAnagrams(strs: List<String>): Boolean {
    if (strs.isEmpty()) return true
    val sorted = strs[0].toCharArray().sorted()
    return strs.all { it.toCharArray().sorted() == sorted }
}
// Time: O(n * m log m), Space: O(n)

fun longestRepeatingSubstring(s: String): Int {
    fun hasRepeat(len: Int): Boolean {
        val seen = hashSetOf<String>()
        for (i in 0..s.length - len) {
            val sub = s.substring(i, i + len)
            if (!seen.add(sub)) return true
        }
        return false
    }
    var left = 1
    var right = s.length
    var res = 0
    while (left <= right) {
        val mid = (left + right) / 2
        if (hasRepeat(mid)) {
            res = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return res
}
// Time: O(n^2 log n), Space: O(n)

fun intersect(nums1: List<Int>, nums2: List<Int>): List<Int> {
    val map = mutableMapOf<Int, Int>()
    nums1.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    val result = mutableListOf<Int>()
    for (num in nums2) {
        if (map.getOrDefault(num, 0) > 0) {
            result.add(num)
            map[num] = map[num]!! - 1
        }
    }
    return result
}
// Time: O(n + m), Space: O(min(n, m))

fun generatePascalTriangle(numRows: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()
    for (i in 0 until numRows) {
        val row = MutableList(i + 1) { 1 }
        for (j in 1 until i) {
            row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        }
        triangle.add(row)
    }
    return triangle
}
// Time: O(n^2), Space: O(n^2)

fun lengthOfLIS(nums: List<Int>): Int {
    val dp = mutableListOf<Int>()
    for (num in nums) {
        val idx = dp.binarySearch(num).let { if (it < 0) -(it + 1) else it }
        if (idx == dp.size) dp.add(num) else dp[idx] = num
    }
    return dp.size
}
// Time: O(n log n), Space: O(n)

fun mergeSort(arr: MutableList<Int>) {
    if (arr.size > 1) {
        val mid = arr.size / 2
        val left = arr.subList(0, mid).toMutableList()
        val right = arr.subList(mid, arr.size).toMutableList()
        mergeSort(left)
        mergeSort(right)
        merge(arr, left, right)
    }
}

fun merge(arr: MutableList<Int>, left: List<Int>, right: List<Int>) {
    var i = 0; var j = 0; var k = 0
    while (i < left.size && j < right.size) {
        arr[k++] = if (left[i] <= right[j]) left[i++] else right[j++]
    }
    while (i < left.size) arr[k++] = left[i++]
    while (j < right.size) arr[k++] = right[j++]
}
// Time: O(n log n), Space: O(n)

fun findKthLargest(nums: IntArray, k: Int): Int {
    val heap = java.util.PriorityQueue<Int>()
    for (num in nums) {
        heap.offer(num)
        if (heap.size > k) heap.poll()
    }
    return heap.peek()
}
// Time: O(n log k), Space: O(k)


fun main() {
    // Q1
    val arr1 = mutableListOf(0, 1, 0, 1, 0, 0, 1)
    moveOnesToEnd(arr1)
    println("Move 1s to end: $arr1")

    // Q2
    val strs2 = listOf("flower", "flow", "flight")
    println("Longest common prefix: ${longestCommonPrefix(strs2)}")

    // Q3
    val arr3 = mutableListOf(1, 0, 1, 0, 1)
    val (pickup, delivery) = reorderPickupDelivery(arr3)
    println("Pickup: $pickup, Delivery: $delivery, Result: $arr3")

    // Q4
    val strs4 = listOf("listen", "silent", "enlist")
    println("All strings are anagrams: ${areAllAnagrams(strs4)}")

    // Q5
    println("Longest repeating substring length: ${longestRepeatingSubstring("banana")}")

    // Q6
    println("Intersection: ${intersect(listOf(1, 2, 2, 3), listOf(2, 2, 3, 4))}")

    // Q7
    println("Pascal's Triangle: ${generatePascalTriangle(5)}")

    // Q8
    println("Longest Increasing Subsequence Length: ${lengthOfLIS(listOf(10, 9, 2, 5, 3, 7, 101, 18))}")

    // Q9
    val arr9 = arrayListOf(5, 2, 3, 1, 4)
    mergeSort(arr9)
    println("Merge sorted array: $arr9")

    // Q10
    println("Kth largest: ${findKthLargest(intArrayOf(3,2,1,5,6,4), 2)}")
}

