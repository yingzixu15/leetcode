from collections import Counter
from typing import List


class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        result = []
        frequency_dict = Counter(nums)
        n = len(nums)
        def backtrack(temp_list: List[int]):
            if len(temp_list) == n:
                result.append(list(temp_list))
                return
            for key in frequency_dict:
                if frequency_dict[key] == 0:
                    continue
                frequency_dict[key] -= 1
                temp_list.append(key)
                backtrack(temp_list)
                temp_list.pop()
                frequency_dict[key] += 1
        backtrack([])
        return result