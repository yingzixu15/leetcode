public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] record = new int[m+1][n+1];
        for (String s: strs) {
            int numZeros = 0;
            int numOnes = 0;
            for (char c: s.toCharArray()) {
                if (c == '0')
                    numZeros++;
                else
                    numOnes++;
            }

            for (int i = m; i >= numZeros; i--) {
                for (int j = n; j >= numOnes; j--) {
                    record[i][j] = Math.max(record[i][j], 1 + record[i - numZeros][j - numOnes]);
                }
            }
        }
        return record[m][n];
    }
}
