public class TwoSum2Sorted {
    public int[] twoSum(int[] numbers, int target) {
        int p1 = 0;
        int p2 = numbers.length - 1;
        int sum;

        while (p1 < p2) {
            sum = numbers[p1] + numbers[p2];
            if (sum < target)
                p1++;
            else if (sum > target)
                p2--;
            else return new int[]{p1 + 1, p2 + 1};
        }
        return null;
    }
}
