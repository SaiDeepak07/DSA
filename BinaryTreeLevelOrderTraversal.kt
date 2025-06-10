package com.example.dsa.binary_trees

data class TreeNode1(
    val value: Int,
    var left: TreeNode1? = null,
    var right: TreeNode1? = null
)

fun levelOrderTraversal(root: TreeNode1?) {
    if (root == null) return

    val queue = mutableListOf<TreeNode1>()
    queue.add(root)

    var index = 0
    while (index < queue.size) {
        val currentNode = queue[index]
        print("${currentNode.value} ")

        currentNode.left?.let { queue.add(it) }
        currentNode.right?.let { queue.add(it) }

        index++
    }
}

fun main() {
    val root = TreeNode1(1)
    root.left = TreeNode1(2)
    root.right = TreeNode1(3)
    root.left?.left = TreeNode1(4)
    root.left?.right = TreeNode1(5)
    root.right?.right = TreeNode1(6)

    println("Level Order Traversal:")
    levelOrderTraversal(root)
}
