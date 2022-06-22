from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution:
    def __init__(self):
        self.count = 0
        self.result = -1
        
    def helper(self, root: Optional[TreeNode], k: int):
        if root is None:
            return
        self.helper(root.left, k)
        self.count += 1
        if self.count == k:
            self.result = root.val
        else:
            self.helper(root.right, k)
            
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.helper(root, k)
        return self.result