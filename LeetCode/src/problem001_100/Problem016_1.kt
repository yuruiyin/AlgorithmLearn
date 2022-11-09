package problem001_100

import kotlin.math.abs

class Problem016_1 {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val size = nums.size
        var ansSum = -1
        var minDiff = Int.MAX_VALUE

        nums.sort()
        nums.forEachIndexed { i, _ ->
            var l = i + 1
            var r = size - 1
            while (l < r) {
                val sum = nums[i] + nums[l] + nums[r]
                val diff = abs(sum - target)
                if (diff <= minDiff) {
                    minDiff = diff
                    ansSum = sum
                }
                when {
                    sum == target -> return sum
                    sum > target -> r--
                    else -> l++
                }
            }
        }

        return ansSum
    }

}