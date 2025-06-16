package com.example.dsa.stack

fun PerfectPrefix(expression: String): Int {
    val stack = ArrayDeque<Int>()

    for (i in expression.length - 1 downTo 0) {
        val char = expression[i]
        when {
            char.isDigit() -> stack.addLast(char.toString().toInt())
            else -> {
                val a = stack.removeLast()
                val b = stack.removeLast()
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
    val prefix = "-+*23 4 5" 
    println("Prefix result: ${PerfectPrefix(prefix.replace(" ", ""))}")
}
