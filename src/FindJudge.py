from typing import List


class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        net_degree = [0] * n
        for t in trust:
            net_degree[t[0] - 1] -= 1
            net_degree[t[1] - 1] += 1
        for i in range(n):
            if net_degree[i] == n-1:
                return i + 1
        return -1