# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        def is_match(n1: Optional[TreeNode], n2: Optional[TreeNode]):
            if n1 is None and n2 is None:
                return True
            if n1 is None or n2 is None:
                return False
            return n1.val == n2.val and is_match(n1.left, n2.left) and is_match(n1.right, n2.right)
        if root is None or subRoot is None:
            return False
        queue = [root]
        while len(queue) > 0:
            node = queue.pop(0)
            if node.val == subRoot.val and is_match(node, subRoot):
                return True
            if node.left is not None:
                queue.append(node.left)
            if node.right is not None:
                queue.append(node.right)
        return False
    