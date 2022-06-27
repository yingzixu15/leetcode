from typing import List, Optional


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binary_search(start: int, end: int) -> Optional[List[int]]:
            if start > end:
                return None
            mid = int(start + (end - start) / 2)
            if nums[mid] > target:
                return binary_search(start, mid - 1)
            if nums[mid] < target:
                return binary_search(mid + 1, end)
            else:
                p1 = mid
                p2 = mid
                while p1 > 0 and nums[p1-1] == target:
                    p1 -= 1
                while p2 < len(nums) - 1 and nums[p2+1] == target:
                    p2 += 1
                return [p1,p2]
        
        pos = binary_search(0, len(nums) - 1)
        if not pos:
            return [-1,-1]
        return pos