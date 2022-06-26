from typing import List


class Solution:
    def findSmallestSetOfVertices(self, n: int, edges: List[List[int]]) -> List[int]:
        result = set(range(n))
        for e in edges:
            if e[1] in result:
                result.remove(e[1])
        return result