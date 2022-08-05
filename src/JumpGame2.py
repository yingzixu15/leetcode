from math import inf
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        if n == 1:
            return 0
        record = [n+1] * n
        record[-1] = 0
        for i in range(n-2, -1, -1):
            if n-1 - i <= nums[i]:
                record[i] = 1
            else:
                j = i+1
                while j < n and j <= i + nums[i]:
                    record[i] = min(record[i], 1 + record[j])
                    j += 1
        return record[0]