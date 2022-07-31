from typing import List


class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        n = len(candidates)
        result = []
        def backtrack(temp_list: List[int], start: int, acc: int):
            if start >= n or candidates[start] > target or acc > target:
                return
            if acc == target:
                result.append(list(temp_list))
                return
            # don't pick the current entry
            backtrack(temp_list, start + 1, acc)
            # pick the current entry
            temp_list.append(candidates[start])
            backtrack(temp_list, start, acc + candidates[start])
            temp_list.pop()
        backtrack([], 0, 0)
        return result