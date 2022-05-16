fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
    val n = grid.size
    if (grid[0][0] == 1 || grid[n-1][n-1] == 1)
        return -1
    val offsets = listOf(Pair(-1,-1), Pair(-1,0), Pair(-1,1), Pair(0,-1), Pair(0,1), Pair(1,-1), Pair(1,0), Pair(1,1))
    val queue = mutableListOf(Pair(0,0))
    val dist = Array(n) { IntArray(n) { Int.MAX_VALUE } }

    dist[0][0] = 1
    while (queue.isNotEmpty()) {
        val currentPos = queue.removeAt(0)
        offsets.forEach {
            val pos = Pair(currentPos.first + it.first, currentPos.second + it.second)
            if (pos.first < 0 || pos.second < 0 || pos.first >= n || pos.second >= n || grid[pos.first][pos.second] == 1 || dist[pos.first][pos.second] < Int.MAX_VALUE)
                return@forEach
            dist[pos.first][pos.second] = dist[currentPos.first][currentPos.second] + 1
            queue.add(pos)
        }
    }
    if (dist[n-1][n-1] < Int.MAX_VALUE)
        return dist[n-1][n-1]
    return -1
}