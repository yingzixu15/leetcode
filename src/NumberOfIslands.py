from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        def dfs(m,n,i,j):
            if not (0 <= i < m and 0 <= j < n):
                return 
            if grid[i][j] == '1':
                grid[i][j] = '0'
                dfs(m,n,i-1,j)
                dfs(m,n,i+1,j)
                dfs(m,n,i,j-1)
                dfs(m,n,i,j+1)
            
        result = 0
        m,n = len(grid), len(grid[0])
        
        for row in range(m):
            for col in range(n):
                if grid[row][col] == '1':
                    result += 1
                    dfs(m,n,row,col)
        
        return result