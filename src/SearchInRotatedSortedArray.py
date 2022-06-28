from typing import List


class Solution:
    def search(self, nums: List[int], target: int) -> int:     
        def binsearch(start, end):
            if start > end:
                return -1
            mid = int(start + (end - start) / 2)
            if nums[mid] > target:
                return binsearch(start, mid - 1)
            elif nums[mid] < target:
                return binsearch(mid + 1, end)
            else:
                return mid

        def find_pivot(start, end, n):
            if start > end:
                return -1
            mid = int(start + (end - start) / 2)
            if mid + 1 < n and nums[mid] > nums[mid + 1]:
                return mid
            elif mid == end:
                return -1
            else:
                return max([find_pivot(start, mid, n), find_pivot(mid + 1, end, n)])

        n = len(nums)
        if not nums[n-1] < nums[0]:
            return binsearch(0, n-1)
        else:
            p = find_pivot(0, n-1, n)
            return max([binsearch(0, p), binsearch(p+1, n-1)])
