package com.example.dsa.binary_trees

data class TreeNode2(
    val value: Int,
    var left: TreeNode2? = null,
    var right: TreeNode2? = null
)

fun printLeftView(root: TreeNode2?) {
    if (root == null) return

    val queue = mutableListOf<Pair<TreeNode2, Int>>()
    queue.add(Pair(root, 0))

    var maxLevel = -1

    while (queue.isNotEmpty()) {
        val (node, level) = queue.removeAt(0)

        if (level > maxLevel) {
            print("${node.value} ")
            maxLevel = level
        }

        node.left?.let { queue.add(Pair(it, level + 1)) }
        node.right?.let { queue.add(Pair(it, level + 1)) }
    }
}


fun main() {
    val root = TreeNode2(1)
    root.left = TreeNode2(2)
    root.right = TreeNode2(3)
    root.left?.left = TreeNode2(4)
    root.left?.left?.left = TreeNode2(6)
    root.right?.right = TreeNode2(5)

    println("Left View of the Binary Tree:")
    printLeftView(root)
}


