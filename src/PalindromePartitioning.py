from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        n = len(s)
        if n == 1:
            return [s]
        result = []
        def is_palindrome(word: str) -> bool:
            p1, p2 = 0, len(word) - 1
            while p1 < p2:
                if word[p1] != word[p2]:
                    return False
                p1 += 1
                p2 -= 1
            return True
        def backtracking(temp_list: List[str], cur_start: int, pos: int):
            if pos == n-1:
                if is_palindrome(s[cur_start:n]):
                    result.append([x for x in temp_list] + [s[cur_start:n]])
                return
            # Check if we can put partition here
            if is_palindrome(s[cur_start:pos+1]):
                temp_list.append(s[cur_start:pos+1])
                backtracking(temp_list, pos + 1, pos + 1)
                temp_list.pop()
            backtracking(temp_list, cur_start, pos + 1)
        
        backtracking([], 0, 0)
        return result