from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        p1, p2 = 0, len(height) - 1
        cur_best = -1
        while p1 < p2:
            area = min(height[p1], height[p2]) * (p2 - p1)
            cur_best = max(cur_best, area)
            if height[p1] > height[p2]:
                p2 -= 1
            else:
                p1 += 1            
        return cur_best