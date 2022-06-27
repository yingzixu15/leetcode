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
                left = binary_search(start, mid - 1)
                right = binary_search(mid + 1, end)
                if left is None and right is None:
                    return [mid, mid]
                if left is None:
                    return [mid, right[1]]
                if right is None:
                    return [left[0], mid]
                else:
                    return [left[0], right[1]]
        
        pos = binary_search(0, len(nums) - 1)
        if not pos:
            return [-1,-1]
        return pos