class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun deepestLeavesSum(root: TreeNode?): Int {
    if (root == null)
        return 0
    var currentLevelQueue = mutableListOf(root)
    var nextLevelQueue = mutableListOf<TreeNode>()
    var deepestLeavesSum = 0
    var temp: MutableList<TreeNode>
    while (true) {
        if (currentLevelQueue.isNotEmpty()) {
            val curNode = currentLevelQueue.removeAt(0)
            deepestLeavesSum += curNode.`val`
            if (curNode.left != null) {
                nextLevelQueue.add(curNode.left!!)
            }
            if (curNode.right != null) {
                nextLevelQueue.add(curNode.right!!)
            }
        } else if (nextLevelQueue.isNotEmpty()) {
            temp = nextLevelQueue
            nextLevelQueue = mutableListOf()
            currentLevelQueue = temp
            deepestLeavesSum = 0
        } else {
            return deepestLeavesSum
        }
    }
}