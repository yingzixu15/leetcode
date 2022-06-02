public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        // result[i] stores the product of nums[0..i-1]
        for (int i = 1; i < n; i++)
            result[i] = result[i-1] * nums[i-1];
        // rightAcc stores the product of nums[n-1..i-1]
        int rightAcc = 1;
        for (int i = n-1; i >= 0; i--) {
            result[i] *= rightAcc;
            rightAcc *= nums[i];
        }
        return result;
    }
}
