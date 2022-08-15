class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[] record = new int[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i-1] == nums[i-1] - nums[i-2]) {
                result += 1 + record[i-1];
                record[i] = 1 + record[i-1];
            }
        }
        return result;
    }
}