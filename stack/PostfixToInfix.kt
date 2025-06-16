package com.example.dsa.stack

fun main() {
    val postfix = "abc*+d-"
    val infix = postfixToInfix(postfix)
    println("Infix: $infix")
}

fun postfixToInfix(expression: String): String {
    val stack = ArrayDeque<String>()

    for (char in expression) {
        if (char.isLetterOrDigit()) {
            stack.addLast(char.toString())
        } else {
            val b = stack.removeLast()
            val a = stack.removeLast()
            stack.addLast("($a$char$b)")
        }
    }

    return stack.last()
}

