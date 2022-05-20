public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == m-1 && j == n-1) {
                    obstacleGrid[i][j] = 1;
                } else if (i == m-1) {
                    obstacleGrid[i][j] = obstacleGrid[i][j+1];
                } else if (j == n-1) {
                    obstacleGrid[i][j] = obstacleGrid[i+1][j];
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i+1][j] + obstacleGrid[i][j+1];
                }
            }
        }
        return obstacleGrid[0][0];
    }
}
