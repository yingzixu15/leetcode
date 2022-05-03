fun findUnsortedSubarray(nums: IntArray): Int {
    var beginIndex = -1
    var endIndex = -1
    var beginFound = false
    var beginIndexBuffer = -1
    var endIndexBuffer = -1
    var endFound = false
    var minval = Int.MAX_VALUE
    var maxval = Int.MIN_VALUE

    for (i in 0..nums.size-2) {
        val j = nums.size - 1 - i;
        if (!beginFound) {
            if ((nums[i] - nums[i + 1]) == 0) {
                if (beginIndexBuffer == -1)
                    beginIndexBuffer = i
            } else if ((nums[i] - nums[i + 1]) > 0) {
                beginIndex = if (beginIndexBuffer == -1) i else beginIndexBuffer
                beginFound = true
                minval = nums[i]
            } else {
                beginIndexBuffer = -1
            }
        } else {
            if (nums[i] < minval)
                minval = nums[i]
        }

        if (!endFound) {
            if ((nums[j] - nums[j - 1]) == 0) {
                if (endIndexBuffer == -1) endIndexBuffer = i
            } else if ((nums[j] - nums[j - 1]) < 0) {
                endIndex = if (endIndexBuffer == -1) j else endIndexBuffer
                endFound = true
                maxval = nums[j]
            } else {
                endIndexBuffer = -1
            }
        } else {
            if (nums[j] > maxval)
                maxval = nums[j]
        }
    }

    if (nums.last() < minval)
        minval = nums.last()
    if (nums[0] > maxval)
        maxval = nums[0]

    for (i in 0..nums.size-1) {
        val j = nums.size - 1 - i;
        if (i >= beginIndex && j <= endIndex)
            break

        if (i < beginIndex && nums[i] > minval)
            beginIndex = i
        if (j > endIndex && nums[j] < maxval)
            endIndex = j
    }

    val length = if (beginIndex >= endIndex) 0 else endIndex - beginIndex + 1
    print(length)
    return length
}


