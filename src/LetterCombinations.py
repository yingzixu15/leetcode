from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if digits == '':
            return []
        alphabets = list(range(ord('a'), ord('o') + 1))
        def get_letters(digit: int) -> List[str]:
            if 2 <= digit <= 6:
                return list(map(lambda x: chr(x), alphabets[(digit - 2)*3:(digit - 2)*3+3]))
            elif digit == 7:
                return ['p', 'q', 'r', 's']
            elif digit == 8:
                return ['t', 'u', 'v']
            else:
                return ['w', 'x', 'y', 'z']
        
        result = []
        def backtrack(temp_string: str, pos: int):
            if pos == len(digits):
                result.append(temp_string)
                return 
            for letter in get_letters(int(digits[pos])):
                backtrack(temp_string + letter, pos + 1)
        backtrack('', 0)
        return result