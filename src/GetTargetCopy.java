import java.util.LinkedList;
import java.util.List;

public class GetTargetCopy {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Integer> path = new LinkedList<>();
        recGetTargetCopy(path, original, target);
        TreeNode curNode = cloned;
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == -1) {
                curNode = curNode.getLeft();
            } else
                curNode = curNode.getRight();
        }
        return curNode;
    }

    private boolean recGetTargetCopy(List<Integer> path, TreeNode node, TreeNode target) {
        if (node == target) {
            return true;
        } else {
            if (node.getLeft() != null && recGetTargetCopy(path, node.getLeft(), target)) {
                path.add(0,-1);
                return true;
            } else if (node.getRight() != null && recGetTargetCopy(path, node.getRight(), target)) {
                path.add(0,1);
                return true;
            }
        }
        return false;
    }
}
