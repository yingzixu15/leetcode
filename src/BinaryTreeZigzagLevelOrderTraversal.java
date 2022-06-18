import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    private LinkedList<TreeNode> curLevel = new LinkedList<>();
    private LinkedList<TreeNode> nextLevel = new LinkedList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        curLevel.add(root);
        recZigzag(result, 0);
        return result;
    }

    private void recZigzag(List<List<Integer>> result, int level) {
        if (curLevel.isEmpty()) return;
        result.add(new ArrayList<>());
        while (!curLevel.isEmpty()) {
            TreeNode cur = getNode(curLevel, level);
            result.get(level).add(cur.val);
            addNodeToList(cur, level);
        }
        this.curLevel = this.nextLevel;
        this.nextLevel = new LinkedList<>();
        recZigzag(result, level + 1);
    }

    private TreeNode getNode(LinkedList<TreeNode> queue, int level) {
        if (level % 2 == 0)
            return queue.removeFirst();
        else return queue.removeLast();
    }

    private void addNodeToList(TreeNode node, int level) {
        if (level % 2 == 1) {
            if (node.right != null)
                nextLevel.addFirst(node.right);
            if (node.left != null)
                nextLevel.addFirst(node.left);
        } else {
            if (node.left != null)
                nextLevel.add(node.left);
            if (node.right != null)
                nextLevel.add(node.right);
        }
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
