/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

fun connect(root: Node?): Node? {
    if (root == null) return null
    var currLayerNodes = listOf(root)
    while (true) {
        val nextLayerNodes = connectHelper(currLayerNodes) ?: break
        currLayerNodes = nextLayerNodes
    }
    return root
}

fun connectHelper(nodes: List<Node>) : List<Node>? {
    if (nodes.isEmpty())
        return null
    for (i in 0..nodes.lastIndex) {
        nodes[i].next = nodes.elementAtOrNull(i+1)
    }
    val nextLayerNodes = nodes.map { listOf(it.left, it.right) }
            .flatten()
            .filterNotNull()
    if (nextLayerNodes.isEmpty())
        return null
    return nextLayerNodes
}