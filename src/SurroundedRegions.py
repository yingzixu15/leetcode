from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def dfs(i,j,m,n):
            if not (0 <= i < m and 0 <= j < n) or board[i][j] != 'O':
                return
            board[i][j] = 'Y'
            dfs(i-1,j,m,n)
            dfs(i+1,j,m,n)
            dfs(i,j-1,m,n)
            dfs(i,j+1,m,n)
            
        def map_board(x):
            if x == 'Y':
                return 'O'
            else: 
                return 'X'
            
        m,n = len(board), len(board[0])
        # horizonal boarders
        for col in range(n):
            if board[0][col] == 'O':
                dfs(0,col,m,n)
            if board[m-1][col] == 'O':
                dfs(m-1,col,m,n)
        
        # vertical boarders
        for row in range(m):
            if board[row][0] == 'O':
                dfs(row,0,m,n)
            if board[row][n-1] == 'O':
                dfs(row,n-1,m,n)
        
        for row in range(m):
            board[row] = list(map(lambda x: map_board(x), board[row]))
