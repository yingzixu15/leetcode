fun sortColors(nums: IntArray): Unit {
    var redPos = 0
    var bluePos = nums.lastIndex
    var i = 0
    while (i <= bluePos) {
        if (nums[i] == 0) {
            nums[i] = nums[redPos].also { nums[redPos] = nums[i] }
            redPos++
        } else if (nums[i] == 2) {
            nums[i] = nums[bluePos].also { nums[bluePos] = nums[i] }
            bluePos--
            i--
        }
        i++
    }
}
