class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        record = [[1] * n for i in range(m)]
        if n == 1 or m == 1:
            return 1
        for row in range(m-2, -1, -1):
            for col in range(n-2, -1, -1):
                record[row][col] = record[row + 1][col] + record[row][col + 1]
                
        return record[0][0]