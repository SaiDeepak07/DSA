package com.example.dsa.june17

fun majorityElement(nums: IntArray): Int? {
    var number: Int? = null
    var count = 0

    for (num in nums) {
        if (count == 0) {
            number = num
        }
        count += if (num == number) 1 else -1
    }

    val frequency = nums.count { it == number }
    return if (frequency > nums.size / 2) number else null
}

fun main() {
    val nums = intArrayOf(2, 2, 1, 1, 2, 2, 2)
    val majority = majorityElement(nums)
    println("Majority element: ${majority ?: "None"}")
}
