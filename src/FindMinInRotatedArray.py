from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums) - 1
        if nums[n] > nums[0] or n == 0:
            return nums[0]
        start, end = 0, n
        while start <= end:
            mid = (start + end) // 2
            if mid + 1 <= n and nums[mid] > nums[mid + 1]:
                return nums[mid + 1]
            if mid - 1 >= 0 and nums[mid] < nums[mid - 1]:
                return nums[mid]
            # not around pivot -> shrink search range
            if nums[mid] > nums[0]:
                start = mid + 1
            else:
                end = mid - 1
        return -1