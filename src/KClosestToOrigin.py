import heapq
import math
from typing import List


class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        def map_points(p):
            return (-math.sqrt(pow(p[0],2)+pow(p[1],2)), p)
        
        points_with_dist = list(map(lambda p: map_points(p), points[:k]))
        heapq.heapify(points_with_dist)
        for p in points[k:]:
            heapq.heappushpop(points_with_dist, map_points(p))
        return list(map(lambda p: p[1], points_with_dist))