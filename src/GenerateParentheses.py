from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        result = []
        def backtrack(temp_string: str, left_count: int, right_count: int):
            # check if current string is valid
            if left_count < right_count or left_count > n or right_count > n:
                return 
            # confirmed valid, if we're done
            if len(temp_string) == 2*n:
                result.append(temp_string)
                return
            # still have available space
            backtrack(temp_string + '(', left_count + 1, right_count)
            backtrack(temp_string + ')', left_count, right_count + 1)
            
        backtrack('', 0, 0)
        return result