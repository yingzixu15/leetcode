class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) <= 1:
            return len(s)
        max_length = 1
        p1, p2 = 0,0
        cur_chars = set()
        while p2 < len(s):
            if s[p2] not in cur_chars:
                cur_chars.add(s[p2])
                p2 += 1
            else:
                max_length = max(max_length, p2 - p1)
                cur_chars.remove(s[p1])
                p1 += 1
        return max(max_length, p2 - p1)