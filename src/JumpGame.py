from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        furthest = 0
        for i in range(len(nums)):
            # cannot reach current position
            if i > furthest:
                return False
            # can reach current position, update furthest position reachable
            furthest = max(furthest, i + nums[i])
        return True