package com.example.dsa.binary_trees

data class TreeNode3(
    val value: Int,
    var left: TreeNode3? = null,
    var right: TreeNode3? = null
)

fun getHeight(root: TreeNode3?): Int {
    if (root == null) return 0

    val leftHeight = getHeight(root.left)
    val rightHeight = getHeight(root.right)

    return 1 + maxOf(leftHeight, rightHeight)
}


fun main() {
    val root = TreeNode3(1)
    root.left = TreeNode3(2)
    root.right = TreeNode3(3)
    root.left?.left = TreeNode3(4)
    root.left?.left?.left = TreeNode3(6)
    root.right?.right = TreeNode3(5)

    val height = getHeight(root)
    println("Height of the Binary Tree: $height")
}
