package com.example.dsa.stack

fun isBalancedParentheses(expression: String): Boolean {
    val stack = Stack<Char>()

    for (char in expression) {
        when (char) {
            '(', '{', '[' -> stack.push(char)
            ')', '}', ']' -> {
                val top = stack.pop() ?: return false
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
    println("Is Balanced: ${isBalancedParentheses(expr)}")
}
