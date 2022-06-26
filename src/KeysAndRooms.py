from typing import List

class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        visited = [False] * len(rooms)
        visited[0] = True
        queue = rooms[0]
        while len(queue) > 0:
            r = queue.pop(0)
            if visited[r]:
                continue
            visited[r] = True
            for k in rooms[r]:
                if not visited[k]:
                    queue.append(k)
            
        return all(visited)