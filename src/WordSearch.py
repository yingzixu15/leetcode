from typing import List


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m,n = len(board), len(board[0])
        visited = [[False for i in range(n)] for j in range(m)]
        
        def backtrack(row: int, col: int, string_pos: int) -> bool:
            if string_pos == len(word):
                return True
            if not (0 <= row < m and 0 <= col < n):
                return False
            if visited[row][col]:
                return False
            if board[row][col] != word[string_pos]:
                return False
            
            visited[row][col] = True
            # try all four directions
            directions = [[0,1], [0,-1], [1,0], [-1,0]]
            for d in directions:
                if backtrack(row + d[0], col + d[1], string_pos + 1):
                    return True
            visited[row][col] = False
            return False
        
        for row in range(m):
            for col in range(n):
                if board[row][col] == word[0]:
                    if backtrack(row, col, 0):
                        return True
        return False
        