package com.example.dsa.stack

class Stack2<T> {
    private val items = mutableListOf<T>()
    fun push(item: T) = items.add(item)
    fun pop(): T? = if (items.isEmpty()) null else items.removeAt(items.size - 1)
    fun peek(): T? = items.lastOrNull()
    fun isEmpty(): Boolean = items.isEmpty()
}


fun evaluatePrefix(expression: String): Int {
    val stack = Stack2<Int>()

    for (i in expression.length - 1 downTo 0) {
        val char = expression[i]
        when {
            char.isDigit() -> stack.push(char.toString().toInt())
            else -> {
                val a = stack.pop() ?: throw IllegalArgumentException("Invalid prefix expression")
                val b = stack.pop() ?: throw IllegalArgumentException("Invalid prefix expression")
                val result = when (char) {
                    '+' -> a + b
                    '-' -> a - b
                    '*' -> a * b
                    '/' -> a / b
                    else -> throw IllegalArgumentException("Unknown operator: $char")
                }
                stack.push(result)
            }
        }
    }

    return stack.pop() ?: throw IllegalStateException("No result found")
}


fun main() {
    val prefix = "-+*23 4 5"
    val cleaned = prefix.replace(" ", "")
    println("Prefix: $prefix")
    println("Result: ${evaluatePrefix(cleaned)}")
}
