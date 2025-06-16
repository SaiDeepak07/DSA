package com.example.dsa.stack

fun prefixToPostfix(expression: String): String {
    val stack = ArrayDeque<String>()

    for (i in expression.length - 1 downTo 0) {
        val char = expression[i]
        if (char.isLetterOrDigit()) {
            stack.addLast(char.toString())
        } else {
            val a = stack.removeLast()
            val b = stack.removeLast()
            stack.addLast("$a$b$char")
        }
    }

    return stack.last()
}

fun main() {
    val prefix = "-+a*bc d"
    val postfix = prefixToPostfix(prefix.replace(" ", ""))
    println("Postfix: $postfix")
}
