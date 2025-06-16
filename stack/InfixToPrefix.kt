package com.example.dsa.stack

fun infixToPrefix(expression: String): String {
    val reversed = expression.reversed().map {
        when (it) {
            '(' -> ')'
            ')' -> '('
            else -> it
        }
    }.joinToString("")
    val postfix = infixToPostfix(reversed)
    return postfix.reversed()
}


fun main() {
    val infix = "a+b*c-d"
    val prefix = infixToPrefix(infix)
    println("Prefix: $prefix")
}
