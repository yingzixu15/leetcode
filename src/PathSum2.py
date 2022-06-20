from optparse import Option
from typing import List, Optional

class PathSum2:
    class TreeNode:
        def __init__(self, val=0, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right
    
    

    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        def dfsHelper(root: Optional[TreeNode], targetSum: int, path: List[int], collection_path: List[List[int]]):
            if root is None:
                return
            if root.left is None and root.right is None and root.val == targetSum:
                path.append(root.val)
                collection_path.append(path)
                return
            else:
                dfsHelper(root.left, targetSum - root.val, path + [root.val], collection_path)
                dfsHelper(root.right, targetSum - root.val, path + [root.val], collection_path)
            
        result = []
        dfsHelper(root, targetSum, [], result)
        return result
