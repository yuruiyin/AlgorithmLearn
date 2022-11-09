package problem001_100

class Problem016_5 {

    private fun sort(nums: IntArray) {
        // 因为数比较小，因此可以用O(N)算法进行排序
        val countArr = IntArray(2001)
        for (num in nums) {
            countArr[num + 1000]++
        }
        var idx = 0
        for (i in 0..2000) {
            var count = countArr[i]
            while (count-- > 0) {
                nums[idx++] = i - 1000
            }
        }
    }

    // 3ms
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        val len = nums.size
        var ansSum = -1
        var minDiff = Int.MAX_VALUE
        //        Arrays.sort(nums);
        sort(nums)
        for (i in len - 1 downTo 2) {
            val gMaxSum = nums[i] + nums[i - 1] + nums[i - 2]
            if (gMaxSum <= target) {
                // 如果当前最大sum都小于等于target，那么继续遍历diff必然会变大，因此直接break
                if (target - gMaxSum < minDiff) {
                    ansSum = gMaxSum
                }
                break
            }
            var r = i - 1
            var l = 0
            while (l < r) {
                val maxSum = nums[i] + nums[r] + nums[r - 1]
                if (maxSum <= target) {
                    // 如果当前最大sum都小于等于target，那么继续遍历diff必然会变大，因此直接break
                    val diff = target - maxSum
                    if (diff < minDiff) {
                        minDiff = diff
                        ansSum = maxSum
                    }
                    break
                }
                val minSum = nums[i] + nums[l] + nums[l + 1]
                if (minSum >= target) {
                    // 如果当前最小sum都大于等于target，那么继续遍历肯定diff必然会变大，因此直接break
                    val diff = minSum - target
                    if (diff < minDiff) {
                        minDiff = diff
                        ansSum = minSum
                    }
                    break
                }
                val sum = nums[i] + nums[l] + nums[r]
                var diff: Int
                when {
                    sum == target -> return sum
                    sum > target -> {
                        diff = sum - target
                        r--
                    }
                    else -> {
                        diff = target - sum
                        l++
                    }
                }
                if (diff < minDiff) {
                    minDiff = diff
                    ansSum = sum
                }
            }
        }
        return ansSum
    }

}