package problem001_100

class Problem016 {

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()

        val size = nums.size
        var minDiff = Int.MAX_VALUE
        var resSum = -1
        for (i in 0 until size) {
            var j = i + 1
            var k = size - 1
            while (j < k) {
                val sum = nums[i] + nums[j] + nums[k]
                val diff = Math.abs(target - sum)
                if (diff < minDiff) {
                    minDiff = diff
                    resSum = sum
                }

                when {
                    sum == target -> return sum
                    sum > target -> k--
                    else -> j++
                }

            }
        }

        return resSum
    }

}

fun main(args: Array<String>) {
    val nums = intArrayOf(-1, 2, 1, -4)
    println(Problem016().threeSumClosest(nums, 1))
}
