from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k <= 1: return 0
        p, start, result = 1, 0, 0
        for end in range(0, len(nums)):
            p *= nums[end]
            while start <= end and p >= k:
                p /= nums[start]
                start += 1
            result += end - start + 1
        return result