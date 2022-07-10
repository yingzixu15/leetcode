class Solution:
    def backspaceCompare(self, s: str, t: str) -> bool:    
        def delete_chars(string: str, pointer: int):
            backspace_count = 0
            while (pointer >= 0 and string[pointer] == '#') or backspace_count > 0:
                if pointer < 0:
                    break
                if string[pointer] == '#':
                    backspace_count += 1
                    pointer -= 1
                else:
                    pointer -= 1
                    backspace_count -= 1
            return pointer
        
        p1 = len(s) - 1
        p2 = len(t) - 1
        while p1 >= 0 and p2 >= 0:
            p1 = delete_chars(s, p1)
            p2 = delete_chars(t, p2)

            if (p1 < 0 and p2 >= 0) or (p2 < 0 and p1 >= 0):
                return False
            if p1 < 0 and p2 < 0:
                return True
            if s[p1] != t[p2]:
                return False
            p1 -= 1
            p2 -= 1
            
        p1 = delete_chars(s, p1)
        p2 = delete_chars(t, p2)

        return p1 < 0 and p2 < 0
