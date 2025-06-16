package com.example.dsa.stack

fun PerfectPostfix(expression: String): Int {
    val stack = ArrayDeque<Int>()

    for (char in expression) {
        when {
            char.isDigit() -> stack.addLast(char.toString().toInt())
            else -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                val result = when (char) {
                    '+' -> a + b
                    '-' -> a - b
                    '*' -> a * b
                    '/' -> a / b
                    else -> throw IllegalArgumentException("Unknown operator: $char")
                }
                stack.addLast(result)
            }
        }
    }
    return stack.last()
}

fun main() {
    val postfix = "23*4+5-"
    println("Postfix result: ${PerfectPostfix(postfix)}")
}
