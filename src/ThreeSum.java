import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int p1 = i+1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = nums[p1] + nums[p2] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    p1++;
                    p2--;
                    while (p1 < nums.length && nums[p1] == nums[p1-1]) p1++;
                    while (p2 >= 0 && nums[p2] == nums[p2+1]) p2--;
                } else if (sum > 0) p2--;
                else p1++;
            }
        }
        return result;
    }
}
