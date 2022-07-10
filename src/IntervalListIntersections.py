from typing import List


class Solution:
    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        p1, p2 = 0,0 
        result = []
        while p1 < len(firstList) and p2 < len(secondList):
            # to verify if firstList[p1] and secondList[p2] overlaps
            h, t = max(firstList[p1][0], secondList[p2][0]), min(firstList[p1][1], secondList[p2][1])
            if h <= t:
                result.append([h,t])
            if firstList[p1][1] >= secondList[p2][1]:
                p2 += 1
            else:
                p1 += 1
        return result