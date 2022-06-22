from collections import deque
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class BSTIterator:
    def __init__(self, root: Optional[TreeNode]):
        self.stack = deque()
        self.pushLeftNodes(root)
    
    def pushLeftNodes(self, root: Optional[TreeNode]):
        if not root:
            return
        while root:
            self.stack.append(root)
            root = root.left
    
    def next(self) -> int:
        result = self.stack.pop()
        self.pushLeftNodes(result.right)    
        return result.val

    def hasNext(self) -> bool:
        return len(self.stack) > 0