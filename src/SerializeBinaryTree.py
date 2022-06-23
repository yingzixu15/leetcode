from typing import List, Optional


class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def recDfs(self, list: List, node: Optional[TreeNode]):
        if node is None:
            list.append('x')
            return
        list.append(str(node.val))
        self.recDfs(list, node.left)
        self.recDfs(list, node.right)

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """

        list = []
        self.recDfs(list, root)
        return ' '.join(list)

    def recHelper(self, squeue: List) -> TreeNode:
        nodeval = squeue.pop(0)
        if nodeval == 'x':
            return None
        node = TreeNode(int(nodeval))
        left = self.recHelper(squeue)
        right = self.recHelper(squeue)
        node.left = left
        node.right = right
        return node

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        squeue = data.split()
        return self.recHelper(squeue)
