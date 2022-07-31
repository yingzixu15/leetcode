from typing import List


class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        result = []
        n = len(candidates)
        candidates.sort()
        def backtrack(temp_list: List[int], start: int, acc:int, is_prev_selected: bool):
            if acc == target:
                result.append(list(temp_list))
                return
            if start >= n or acc > target or candidates[start] > target:
                return 
            # don't pick the current one
            backtrack(temp_list, start + 1, acc, False)
            
            # pick the current one, provided it doesn't result in duplication
            if start > 0 and candidates[start] == candidates[start - 1] and not is_prev_selected:
                return 
            temp_list.append(candidates[start])
            backtrack(temp_list, start + 1, acc + candidates[start], True)
            temp_list.pop()
        backtrack([], 0, 0, False)
        return result