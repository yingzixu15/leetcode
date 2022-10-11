class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        if left == 0 or left == right:
            return left
        moved = 0
        while left != right:
            left >>= 1
            right >>= 1
            moved += 1
        return left << moved