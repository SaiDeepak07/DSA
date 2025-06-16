package com.example.dsa.stack

fun BalancedParenthese(expression: String): Boolean {
    val stack = ArrayDeque<Char>()
    for (char in expression) {
        when (char) {
            '(', '{', '[' -> stack.addLast(char)
            ')', '}', ']' -> {
                if (stack.isEmpty()) return false
                val top = stack.removeLast()
                if ((char == ')' && top != '(') ||
                    (char == '}' && top != '{') ||
                    (char == ']' && top != '[')) return false
            }
        }
    }
    return stack.isEmpty()
}
fun main() {
    val expr = "{(a+b)*[c-d]}"
    println("Is Balanced: ${BalancedParenthese(expr)}")
}
