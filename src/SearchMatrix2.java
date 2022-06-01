public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            if (val == target)
                return true;
            else if (val > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}
