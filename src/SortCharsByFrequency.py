from collections import Counter
import heapq


class Solution:
    def frequencySort(self, s: str) -> str:
        def tuple_map(x):
            p = tuple(reversed(x))
            return (-p[0], p[1])
        fmap = Counter(s)
        entries = list(map(lambda x: tuple_map(x), fmap.items()))
        heapq.heapify(entries)
        result = ""
        while len(entries) > 0:
            p = heapq.heappop(entries)
            result = result + str(p[1]) * (-p[0])
        return result