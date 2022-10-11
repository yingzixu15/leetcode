class Solution:
    def isHappy(self, n: int) -> bool:
        if n == 1:
            return True
        if 1 < n < 3:
            return False
        fast, slow = sum(map(lambda x: x ** 2, [int(c) for c in str(n)])), n
        while fast != slow:
            fast = sum(map(lambda x: x ** 2, [int(c) for c in str(fast)]))
            fast = sum(map(lambda x: x ** 2, [int(c) for c in str(fast)]))
            slow = sum(map(lambda x: x ** 2, [int(c) for c in str(slow)]))
            if fast == 1:
                return True
            if 1 < fast < 3:
                return False
        return False