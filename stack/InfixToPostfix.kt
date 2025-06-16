package com.example.dsa.stack

fun infixToPostfix(expression: String): String {
    val stack = ArrayDeque<Char>()
    val output = StringBuilder()

    fun precedence(op: Char): Int = when (op) {
        '+', '-' -> 1
        '*', '/' -> 2
        else -> -1
    }

    for (char in expression) {
        when {
            char.isLetterOrDigit() -> output.append(char)
            char == '(' -> stack.addLast(char)
            char == ')' -> {
                while (stack.isNotEmpty() && stack.last() != '(')
                    output.append(stack.removeLast())
                stack.removeLast() // remove '('
            }
            else -> {
                while (stack.isNotEmpty() && precedence(stack.last()) >= precedence(char))
                    output.append(stack.removeLast())
                stack.addLast(char)
            }
        }
    }

    while (stack.isNotEmpty()) output.append(stack.removeLast())
    return output.toString()
}


fun main() {
    val infix = "a+b*c-d"
    val postfix = infixToPostfix(infix)
    println("Postfix: $postfix")
}
