package com.example.dsa.stack

class Stack<T> {
    private val items = mutableListOf<T>()
    fun push(item: T) = items.add(item)
    fun pop(): T? = if (items.isEmpty()) null else items.removeAt(items.size - 1)
    fun peek(): T? = items.lastOrNull()
    fun isEmpty(): Boolean = items.isEmpty()
}

fun infixToPostfix(expression: String): String {
    val stack = Stack<Char>()
    val output = StringBuilder()

    fun precedence(op: Char): Int = when (op) {
        '+', '-' -> 1
        '*', '/', '%' -> 2
        else -> -1
    }

    for (char in expression) {
        when {
            char.isLetterOrDigit() -> output.append(char)
            char == '(' -> stack.push(char)
            char == ')' -> {
                while (!stack.isEmpty() && stack.peek() != '(')
                    output.append(stack.pop())
                stack.pop()
            }
            else -> {
                while (!stack.isEmpty() && precedence(stack.peek()!!) >= precedence(char))
                    output.append(stack.pop())
                stack.push(char)
            }
        }
    }

    while (!stack.isEmpty())
        output.append(stack.pop())

    return output.toString()
}

fun main() {
    val infix = "a+b*c-d%e"
    val postfix = infixToPostfix(infix)
    println("Infix: $infix")
    println("Postfix: $postfix")
}
