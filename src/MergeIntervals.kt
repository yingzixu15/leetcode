import kotlin.math.max

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size == 1)
            return intervals
        intervals.sortBy { it[0] }
        val result = mutableListOf<IntArray>()
        var start = intervals[0][0]
        var end = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][0] <= end) {
                end = max(end, intervals[i][1])
            }
            else {
                result.add(intArrayOf(start, end))
                start = intervals[i][0]
                end = intervals[i][1]
            }
            if (i == intervals.lastIndex)
                result.add(intArrayOf(start, end))
        }
        return result.toTypedArray()
    }
}