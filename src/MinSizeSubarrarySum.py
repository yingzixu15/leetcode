from typing import List

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        result, s, start = len(nums) + 1, 0, 0
        for end in range(0, len(nums)):
            if nums[end] >= target:
                return 1
            s += nums[end]
            if s < target:
                continue
            while start <= end and s >= target:
                s -= nums[start]
                start += 1
            result = min(result, end - start + 2)
        if start == 0 and s < target:
            return 0
        return result