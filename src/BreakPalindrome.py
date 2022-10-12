class Solution:
    def breakPalindrome(self, palindrome: str) -> str:
        if len(palindrome) == 1:
            return ""
        mid = len(palindrome) // 2
        for p in range(0,len(palindrome)):
            if palindrome[p] != 'a':
                if p == mid and len(palindrome) % 2 == 1:
                    continue
                if p < len(palindrome) - 1:
                    return palindrome[:p] + 'a' + palindrome[p+1:]
                else:
                    return palindrome[:-1] + 'a'
        return palindrome[:-1] + 'b'