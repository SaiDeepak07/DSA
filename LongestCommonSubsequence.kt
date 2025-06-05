package com.example.dsa

fun longestCommonSubsequence(strings: List<String>): String {
    if (strings.isEmpty()) return ""
    var lcs = strings[0]

    for (i in 1 until strings.size) {
        lcs = lcsOfTwo(lcs, strings[i])
        if (lcs.isEmpty()) break
    }

    return lcs
}

fun lcsOfTwo(a: String, b: String): String {
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }

    for (i in a.indices) {
        for (j in b.indices) {
            if (a[i] == b[j]) {
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                dp[i + 1][j + 1] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }

    // Reconstruct LCS
    var i = a.length
    var j = b.length
    val result = StringBuilder()

    while (i > 0 && j > 0) {
        when {
            a[i - 1] == b[j - 1] -> {
                result.append(a[i - 1])
                i--
                j--
            }
            dp[i - 1][j] > dp[i][j - 1] -> i--
            else -> j--
        }
    }

    return result.reverse().toString()
}

fun main() {
    val strings = listOf("abcde", "ace", "abcdef")
    println("Longest Common Subsequence: ${longestCommonSubsequence(strings)}")
}
