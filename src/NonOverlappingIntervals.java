import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1])
                return o1[0]-o2[0];
            else return o1[1]-o2[1];
        });
        System.out.println(Arrays.deepToString(intervals));
        int n = intervals.length;
        int rightEnd = intervals[0][1];
        int numRemovals = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < rightEnd) {
                numRemovals++;
            } else {
                rightEnd = Math.max(rightEnd, intervals[i][1]);
            }
        }
        return numRemovals;
    }
}
