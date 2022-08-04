from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0]
        
        def robInRange(start: int, end: int):
            rob, not_rob = 0,0
            for i in range(start, end + 1):
                rob, not_rob = not_rob + nums[i], max(rob, not_rob)
            return max(rob, not_rob)
        
        return max(robInRange(0,n-2), robInRange(1,n-1))