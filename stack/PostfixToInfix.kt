package com.example.dsa.stack

class Stack3<T> {
    private val items = mutableListOf<T>()
    fun push(item: T) = items.add(item)
    fun pop(): T = items.removeAt(items.size - 1)
    fun peek(): T = items.last()
    fun isEmpty(): Boolean = items.isEmpty()
}

fun postfixToInfix(expression: String): String {
    val stack = Stack3<String>()

    for (char in expression) {
        if (char.isLetterOrDigit()) {
            stack.push(char.toString())
        } else {
            val b = stack.pop()
            val a = stack.pop()
            stack.push("($a$char$b)")
        }
    }

    return stack.peek()
}

fun main() {
    val postfix = "abc*+d-"
    val infix = postfixToInfix(postfix)
    println("Postfix: $postfix")
    println("Infix: $infix")
}
