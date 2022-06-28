from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        start, end = 0, m - 1
        while start < end:
            mid = (start + end) // 2

            if matrix[mid][0] == target:
                return True
            elif matrix[mid][0] > target:
                end = mid - 1
            else:
                if matrix[mid][n - 1] == target:
                    return True
                elif matrix[mid][n - 1] > target:
                    end = mid
                else:
                    start = mid + 1
        r = start
        start, end = 0, n - 1
        while start <= end:
            mid = (start + end) // 2
            if matrix[r][mid] == target:
                return True
            elif matrix[r][mid] > target:
                end = mid - 1
            else:
                start = mid + 1
        return False
