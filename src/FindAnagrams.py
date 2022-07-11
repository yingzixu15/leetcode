from collections import Counter
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        if len(s) == 0 or len(p) == 0 or len(s) < len(p):
            return []
        
        fmap = [0] * 26
        for c in p:
            fmap[ord(c) - ord('a')] += 1
        result = []
        
        # initial window
        start, end, counter = 0, 0, len(p)
        while end < len(p):
            index = ord(s[end]) - ord('a')
            fmap[index] -= 1
            if fmap[index] >= 0:
                counter -= 1
            end += 1
        
        if counter == 0:
            result.append(0)
        
        # slide the whole window from now on
        while end < len(s):
            # remove the first entry in the window
            index = ord(s[start]) - ord('a')
            fmap[index] += 1
            if fmap[index] >= 1:
                counter += 1
            start += 1
            
            index = ord(s[end]) - ord('a')
            fmap[index] -= 1
            if fmap[index] >= 0:
                counter -= 1
            end += 1
            
            if counter == 0:
                result.append(start)
        
        return result