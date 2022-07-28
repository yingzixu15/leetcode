from typing import List


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        def backtrack(result: List[List[int]], temp_list: List[int], start: int, n: int, k: int):
            if len(temp_list) == k:
                result.append(temp_list)
                return
            for i in range(start, n):
                temp_list.append(nums[i])
                backtrack(result, temp_list,i+1,n,k)
                temp_list.pop() 
        
        n = len(nums)
        result = []
        for k in range(0, n+1):
            backtrack(result, [], 0, n, k)
        return result
    
    
    
    def subsets_alternative(self, nums: List[int]) -> List[List[int]]:
        result = [[]]
        for x in nums:
            cur_size = len(result)
            for i in range(cur_size):
                result.append(result[i] + [x])
        return result