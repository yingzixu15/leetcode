import java.util.Arrays;

public class SpiralMatrix2 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        for (int[] row: result) {
            Arrays.fill(row, -1);
        }
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }

        int curDim = n;
        int startPos = 0;
        int marker = 1;
        while (curDim > 0) {
            for (int i = startPos; i < n-startPos && result[startPos][i] == -1; i++) {
                result[startPos][i] = marker;
                marker++;
            }
            for (int i = startPos+1; i < n-startPos && result[i][n-startPos-1] == -1; i++) {
                result[i][n-startPos-1] = marker;
                marker++;
            }
            for (int i = n-startPos-2; i >= startPos && result[n-startPos-1][i] == -1; i--) {
                result[n-startPos-1][i] = marker;
                marker++;
            }
            for (int i = n-startPos-2; i > startPos && result[i][startPos] == -1; i--) {
                result[i][startPos] = marker;
                marker++;
            }
            curDim -= 2;
            startPos++;
        }
        return result;
    }
}
