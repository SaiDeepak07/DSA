package com.example.dsa.stack

fun main() {
    val postfix = "abc*+d-"
    val prefix = postfixToPrefix(postfix)
    println("Prefix: $prefix")
}

fun postfixToPrefix(expression: String): String {
    val stack = ArrayDeque<String>()

    for (char in expression) {
        if (char.isLetterOrDigit()) {
            stack.addLast(char.toString())
        } else {
            val b = stack.removeLast()
            val a = stack.removeLast()
            stack.addLast("$char$a$b")
        }
    }

    return stack.last()
}
