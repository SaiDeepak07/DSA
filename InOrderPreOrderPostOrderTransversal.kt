package com.example.dsa.binary_trees

// Tree node class
data class TreeNode(
    val value: Int,
    var left: TreeNode1? = null,
    var right: TreeNode1? = null
)

// Inorder traversal
fun inorderTraversal(root: TreeNode1?) {
    val stack = mutableListOf<TreeNode1>()
    var current = root

    while (current != null || stack.isNotEmpty()) {
        while (current != null) {
            stack.add(current)
            current = current.left
        }
        current = stack.removeAt(stack.size - 1)
        print("${current.value} ")
        current = current.right
    }
}

// Preorder traversal
fun preorderTraversal(root: TreeNode1?) {
    if (root == null) return
    val stack = mutableListOf<TreeNode1>()
    stack.add(root)

    while (stack.isNotEmpty()) {
        val node = stack.removeAt(stack.size - 1)
        print("${node.value} ")

        node.right?.let { stack.add(it) }
        node.left?.let { stack.add(it) }
    }
}

// Postorder traversal
fun postorderTraversal(root: TreeNode1?) {
    if (root == null) return
    val stack1 = mutableListOf<TreeNode1>()
    val stack2 = mutableListOf<TreeNode1>()

    stack1.add(root)

    while (stack1.isNotEmpty()) {
        val node = stack1.removeAt(stack1.size - 1)
        stack2.add(node)

        node.left?.let { stack1.add(it) }
        node.right?.let { stack1.add(it) }
    }

    while (stack2.isNotEmpty()) {
        val node = stack2.removeAt(stack2.size - 1)
        print("${node.value} ")
    }
}

fun main() {
    val root = TreeNode1(1)
    root.left = TreeNode1(2)
    root.right = TreeNode1(3)
    root.left?.left = TreeNode1(4)
    root.left?.right = TreeNode1(5)
    root.right?.right = TreeNode1(6)

    println("Inorder Traversal:")
    inorderTraversal(root)

    println("\nPreorder Traversal:")
    preorderTraversal(root)

    println("\nPostorder Traversal:")
    postorderTraversal(root)
}
