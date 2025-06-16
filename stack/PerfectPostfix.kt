package com.example.dsa.stack


class Stack1<T> {
    private val items = mutableListOf<T>()
    fun push(item: T) = items.add(item)
    fun pop(): T? = if (items.isEmpty()) null else items.removeAt(items.size - 1)
    fun peek(): T? = items.lastOrNull()
    fun isEmpty(): Boolean = items.isEmpty()
}


fun evaluatePostfix(expression: String): Int {
    val stack = Stack1<Int>()

    for (char in expression) {
        when {
            char.isDigit() -> stack.push(char.toString().toInt())
            else -> {
                val b = stack.pop() ?: throw IllegalArgumentException("Invalid postfix expression")
                val a = stack.pop() ?: throw IllegalArgumentException("Invalid postfix expression")
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

// Main function
fun main() {
    val postfix = "23*4+5-"
    println("Postfix: $postfix")
    println("Result: ${evaluatePostfix(postfix)}")
}
