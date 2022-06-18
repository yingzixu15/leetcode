public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        else if (nums.length == 1)
            return new TreeNode(nums[0]);

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int low, int high) {
        if (low > high)
            return null;
        else if (low == high)
            return new TreeNode(nums[low]);
        int mid = low + (high - low) / 2;
        TreeNode left = sortedArrayToBSTHelper(nums, low, mid - 1);
        TreeNode right = sortedArrayToBSTHelper(nums, mid + 1, high);
        return new TreeNode(nums[mid], left, right);
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
