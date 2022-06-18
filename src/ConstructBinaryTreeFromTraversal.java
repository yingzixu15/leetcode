import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderValPosMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            inorderValPosMap.put(inorder[i], i);

        return recHelper(preorder, 0, inorder.length - 1, 0, inorderValPosMap);
    }

    private TreeNode recHelper(int[] preorder, int inStart, int inEnd, int preStart, Map<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        int root = preorder[preStart];
        int rootPosIn = map.get(root);
        // left tree size = rootPosIn - inStart
        TreeNode left = recHelper(preorder, inStart, rootPosIn - 1, preStart + 1, map);
        TreeNode right = recHelper(preorder, rootPosIn + 1, inEnd, preStart + rootPosIn - inStart + 1, map);
        return new TreeNode(root, left, right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
