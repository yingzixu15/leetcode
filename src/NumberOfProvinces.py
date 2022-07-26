from typing import List


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def dfs(i, visited):
            if visited[i]:
                return
            visited[i] = True
            neighbours = filter(lambda x: isConnected[i][x] == 1, range(n))
            for c in neighbours:
                dfs(c, visited)
        n = len(isConnected)
        visited = [False] * n
        result = 0
        for row in range(n):
            if visited[row]:
                continue
            result += 1
            dfs(row, visited)
        return result
