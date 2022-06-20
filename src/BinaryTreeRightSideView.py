from queue import Queue
from typing import List, Optional

class BinaryTreeRightSideView:
    class TreeNode:
        def __init__(self, val=0, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right
    
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
            if root is None:
                return []
            result = []
            queue = Queue()
            queue.put(root)
            while not queue.empty():
                last_val = -1
                next_level = Queue()
                while not queue.empty():
                    cur = queue.get()
                    if queue.empty():
                        last_val = cur.val
                    if cur.left is not None:
                        next_level.put(cur.left)
                    if cur.right is not None:
                        next_level.put(cur.right)
                result.append(last_val)
                queue = next_level

            return result