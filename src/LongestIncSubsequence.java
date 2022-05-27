import java.util.Arrays;

// solution idea based on https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation

public class LongestIncSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num: nums) {
            int bsResult = Arrays.binarySearch(tails, 0, size, num);
            if (bsResult < 0) {
                bsResult = -bsResult - 1;
                if (bsResult == size)
                    size++;
                tails[bsResult] = num;
            }
        }
        return size;
    }
}
