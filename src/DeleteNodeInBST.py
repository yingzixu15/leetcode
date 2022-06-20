from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class DeleteNodeInBST:
    
    def deleteNode(self, root: Optional[TreeNode], key: int) -> Optional[TreeNode]:
        def delete(root: Optional[TreeNode]) -> Optional[TreeNode]:
            if root is None:
                return None
            if root.left is None and root.right is None:
                return None
            if root.left is not None and root.right is not None:
                # find min value of the right subtree -> new root
                rightMin = root.right
                prev = root
                while True:
                    if rightMin.left is not None:
                        prev = rightMin
                        rightMin = rightMin.left
                    else:
                        break
                if prev == root:
                    prev.right = delete(rightMin)
                else:
                    prev.left = delete(rightMin)
                rightMin.left = root.left
                rightMin.right = root.right
                return rightMin
            if root.left is not None:
                return root.left
            if root.right is not None:
                return root.right
            
            
        
        if root is None:
            return None
        cur = root
        prev = None
        found = False
        isGoingLeft = None
        while cur is not None:
            if cur.val == key:
                found = True
                break
            elif cur.val > key:
                prev = cur
                cur = cur.left
                isGoingLeft = True
            else:
                prev = cur
                cur = cur.right
                isGoingLeft = False
        
        if not found:
            return root
        if isGoingLeft is None:
            return delete(root)
        elif isGoingLeft:
            prev.left = delete(cur)
            return root
        else:
            prev.right = delete(cur)
            return root
    