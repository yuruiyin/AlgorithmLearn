package problem301_400

import kotlin.math.max

fun maxRotateFunction(nums: IntArray): Int {
    val sum = nums.sum()
    var ansMax = 0
    nums.forEachIndexed { index, value ->
        ansMax += index * value
    }
    var preValue = ansMax
    val n = nums.size
    for (k in 1 until n) {
        preValue += sum - n * nums[n - k]
        ansMax = max(ansMax, preValue)
    }
    return ansMax
}
