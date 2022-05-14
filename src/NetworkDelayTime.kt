// using BFS + Dijkstra - all paths are shortest path
fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
    val dist = mutableMapOf<Int, Int>()
    val queue = mutableListOf<Int>()
    val neighbours = mutableMapOf<Int, MutableList<Int>>()
    val edges = times.associate { Pair(it[0], it[1]) to it[2] }
    for (i in 1..n) {
        dist[i] = Int.MAX_VALUE
        queue.add(i)
    }
    times.forEach {
        if (!neighbours.containsKey(it[0]))
            neighbours[it[0]] = mutableListOf(it[1])
        else
            neighbours[it[0]]?.add(it[1])
    }
    dist[k] = 0

    while (queue.isNotEmpty()) {
        val u = queue.map { Pair(it, dist[it]) }
                .minByOrNull { it.second!! }!!
                .first
        queue.remove(u)
        val uNeighbours = neighbours[u] ?: continue
        for (v in uNeighbours) {
            if (!queue.contains(v)) {
                continue
            }
            val alt = edges[Pair(u,v)]?.let { dist[u]?.plus(it) }
            if (alt != null) {
                if (alt < dist[v]!!) {
                    dist[v] = alt
                }
            }
        }
    }
    val maxDist = dist.values.maxByOrNull { it }!!
    if (maxDist == Int.MAX_VALUE)
        return -1
    return maxDist
}
