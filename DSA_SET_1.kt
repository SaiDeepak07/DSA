// 1. Maximum Profit from Stock Prices
// Time Complexity: O(n)
// Space Complexity: O(1)
fun maxProfit(prices: ArrayList<Int>): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0
    for (price in prices) {
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }
    return maxProfit
}

// 2. Find all pairs with target sum
// Time Complexity: O(n^2)
// Space Complexity: O(1)
fun findPairs(nums: ArrayList<Int>, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                result.add(listOf(nums[i], nums[j]))
            }
        }
    }
    return result
}

// 3. Merge Intervals
// Time Complexity: O(n log n)
// Space Complexity: O(n)
fun mergeIntervals(intervals: List<IntArray>): List<IntArray> {
    if (intervals.isEmpty()) return emptyList()
    val sorted = intervals.sortedBy { it[0] }
    val merged = mutableListOf<IntArray>()
    var current = sorted[0]
    for (i in 1 until sorted.size) {
        if (current[1] >= sorted[i][0]) {
            current[1] = maxOf(current[1], sorted[i][1])
        } else {
            merged.add(current)
            current = sorted[i]
        }
    }
    merged.add(current)
    return merged
}

// 4. First Non-Repeating Character
// Time Complexity: O(n)
// Space Complexity: O(1)
fun firstUniqChar(s: String): Int {
    val count = IntArray(26)
    for (ch in s) count[ch - 'a']++
    for (i in s.indices) {
        if (count[s[i] - 'a'] == 1) return i
    }
    return -1
}

// 5. Find Words Matching Pattern
// Time Complexity: O(n * m) n = number of words, m = length of each word
// Space Complexity: O(m)
fun findAndMatchPattern(words: List<String>, pattern: String): List<String> {
    fun normalize(word: String): String {
        val map = mutableMapOf<Char, Char>()
        var next = 'a'
        return word.map {
            map.getOrPut(it) { next++ }
        }.joinToString("")
    }
    val patternNormalized = normalize(pattern)
    return words.filter { normalize(it) == patternNormalized }
}

// 6. Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)
fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        when {
            arr[mid] == target -> return mid
            arr[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }
    }
    return -1
}

// 7. Merge Two Sorted Linked Lists
// Time Complexity: O(n + m)
// Space Complexity: O(1)
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    var l1 = list1
    var l2 = list2

    while (l1 != null && l2 != null) {
        if (l1.`val` <= l2.`val`) {
            tail.next = l1
            l1 = l1.next
        } else {
            tail.next = l2
            l2 = l2.next
        }
        tail = tail.next!!
    }
    tail.next = l1 ?: l2
    return dummy.next
}

// 8. Remove Duplicates in Sorted Array
// Time Complexity: O(n)
// Space Complexity: O(1)
fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var index = 1
    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1]) {
            nums[index++] = nums[i]
        }
    }
    return index
}

// 9. Rotate Array
// Time Complexity: O(n)
// Space Complexity: O(1)
fun rotate(nums: IntArray, k: Int) {
    val n = nums.size
    val step = k % n
    reverse(nums, 0, n - 1)
    reverse(nums, 0, step - 1)
    reverse(nums, step, n - 1)
}

fun reverse(nums: IntArray, start: Int, end: Int) {
    var s = start
    var e = end
    while (s < e) {
        val temp = nums[s]
        nums[s] = nums[e]
        nums[e] = temp
        s++
        e--
    }
}

// 10. Maximum Subarray Sum
// Time Complexity: O(n)
// Space Complexity: O(1)
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currentSum = nums[0]
    for (i in 1 until nums.size) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}

// 11. Move Zeroes
// Time Complexity: O(n)
// Space Complexity: O(1)
fun moveZeroes(nums: IntArray) {
    var insertPos = 0
    for (num in nums) {
        if (num != 0) nums[insertPos++] = num
    }
    while (insertPos < nums.size) {
        nums[insertPos++] = 0
    }
}

fun main() {
    println("1. Max Profit: " + maxProfit(arrayListOf(7,1,5,3,6,4)))
    println("2. Pairs with sum 5: " + findPairs(arrayListOf(1,2,3,4,5), 5))
    println("3. Merged Intervals: " + mergeIntervals(listOf(intArrayOf(1,3), intArrayOf(2,6), intArrayOf(8,10), intArrayOf(15,18))).map { it.toList() })
    println("4. First Non-Repeating Index: " + firstUniqChar("leetcode"))
    println("5. Match Pattern 'abb': " + findAndMatchPattern(listOf("abc","deq","mee","aqq","dkd","ccc"), "abb"))
    println("6. Binary Search (target 3): " + binarySearch(intArrayOf(1,2,3,4,5), 3))

    val l1 = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(4) } }
    val l2 = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    var merged = mergeTwoLists(l1, l2)
    print("7. Merged Linked Lists: ")
    while (merged != null) {
        print("${merged.`val`} ")
        merged = merged.next
    }
    println()

    val nums8 = intArrayOf(1,1,2)
    val len8 = removeDuplicates(nums8)
    println("8. Remove Duplicates: ${nums8.slice(0 until len8)}")

    val nums9 = intArrayOf(1,2,3,4,5,6,7)
    rotate(nums9, 3)
    println("9. Rotated Array: ${nums9.toList()}")

    println("10. Max SubArray: " + maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4)))

    val nums11 = intArrayOf(0,1,0,3,12)
    moveZeroes(nums11)
    println("11. Move Zeroes: ${nums11.toList()}")
}