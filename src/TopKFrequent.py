import heapq
from typing import List


class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        fmap = {}
        for n in nums:
            if n in fmap:
                fmap[n] += 1
            else:
                fmap[n] = 1
        entries = list(map(lambda x: tuple(reversed(x)), fmap.items()))
        head_entries = entries[:k]
        heapq.heapify(head_entries)
        for p in entries[k:]:
            heapq.heappushpop(head_entries, p)
        return list(map(lambda x: x[1], head_entries))