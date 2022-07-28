from typing import List


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        def backtrack(result: List[List[int]], temp_list: List[int], start: int, n: int, is_prev_added: bool):
            if start == n:
                result.append([item for item in temp_list])
                return
            # don't pick current entry
            backtrack(result, temp_list, start + 1, n, False)
            
            # pick current entry, provided the previous duplicate is picked
            if start > 0 and nums[start] == nums[start - 1] and not is_prev_added:
                return 
            temp_list.append(nums[start])
            backtrack(result, temp_list, start + 1, n, True)
            temp_list.pop()
            
            
        
        nums.sort()
        result = []
        backtrack(result, [], 0, len(nums))
        return result
        
        
        