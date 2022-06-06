import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[][] intervals = new int[26][2];

        for (int i = 0; i < 26; i++) {
            intervals[i][0] = -1;
            intervals[i][1] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (intervals[index][0] == -1)
                intervals[index][0] = i;
            if (i > intervals[index][1])
                intervals[index][1] = i;
        }

        List<int[]> filteredIntervals = Arrays.stream(intervals).filter(l -> l[0] != -1).collect(Collectors.toList());

        filteredIntervals.sort((l1,l2) -> {
            if (l1[0] == l2[0])
                return l1[1] - l2[1];
            else return l1[0] - l2[0];
        });

        if (filteredIntervals.size() == 0)
            return Collections.emptyList();

        List<Integer> result = new ArrayList<>();

        int[] curList = filteredIntervals.get(0);
        int left = curList[0];
        int right = curList[1];
        for (int i = 1; i < filteredIntervals.size(); i++) {
            curList = filteredIntervals.get(i);
            if (curList[0] < right)
                right = Math.max(right, curList[1]);
            else {
                result.add(right - left + 1);
                left = curList[0];
                right = curList[1];
            }
            if (i == filteredIntervals.size() - 1)
                result.add(right - left + 1);
        }

        return result;
    }
}
