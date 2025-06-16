package com.example.dsa.stack

class Stack5<T> {
    private val items = mutableListOf<T>()
    fun push(item: T) = items.add(item)
    fun pop(): T = items.removeAt(items.size - 1)
    fun peek(): T = items.last()
    fun isEmpty(): Boolean = items.isEmpty()
}

fun prefixToPostfix(expression: String): String {
    val stack = Stack5<String>()

    for (i in expression.length - 1 downTo 0) {
        val char = expression[i]
        if (char.isLetterOrDigit()) {
            stack.push(char.toString())
        } else {
            val a = stack.pop()
            val b = stack.pop()
            stack.push("$a$b$char")
        }
    }

    return stack.peek()
}

fun main() {
    val prefix = "-+a*bc d"
    val cleaned = prefix.replace(" ", "")
    val postfix = prefixToPostfix(cleaned)
    println("Prefix: $prefix")
    println("Postfix: $postfix")
}
