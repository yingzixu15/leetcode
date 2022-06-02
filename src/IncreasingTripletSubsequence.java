public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= min)
                min = num;
            else if (num <= max)
                max = num;
            else return true;
        }
        return false;
    }
}
