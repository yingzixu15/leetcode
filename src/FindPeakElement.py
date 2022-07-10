from typing import List


class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        n = len(nums) - 1
        # check head and tail
        if n == 0 or nums[0] > nums[1]:
            return 0
        if nums[n] > nums[n-1]:
            return n
        
        start, end = 0, n 
        while start < end:
            mid = (start + end) // 2
            if 0 < mid < n  and nums[mid - 1] < nums[mid] and nums[mid + 1] < nums[mid]:
                return mid 
            # is it increasing or decreasing at mid? 
            if mid < n and nums[mid] < nums[mid + 1]:
                start = mid + 1
            else:
                end = mid - 1
        return start