import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        pqueue = nums[:k]
        heapq.heapify(pqueue)
        for x in nums[k:]:
            heapq.heappushpop(pqueue, x)
        return pqueue[0]