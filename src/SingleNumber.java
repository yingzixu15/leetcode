/***
 * Bit-wise XOR operation: suppose x is nonzero.
 * 0 ^ x = x
 * x ^ x = 0
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num: nums) {
            xor ^= num;
        }
        return xor;
    }
}
