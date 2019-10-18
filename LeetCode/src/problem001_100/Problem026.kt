package problem001_100

class Problem026 {

    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty() || nums.size == 1) {
            return nums.size
        }

        val size = nums.size
        var lastNumIndex = 0
        for (i in 1 until size) {
            if (nums[i] != nums[lastNumIndex]) {
                if (i > lastNumIndex + 1) {
                    // 替换
                    nums[lastNumIndex + 1] = nums[i]
                }
                lastNumIndex++
            }
        }

        return lastNumIndex + 1
    }

}

fun main(args: Array<String>) {
//    val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    val nums = intArrayOf(1, 2, 2)
//    val nums = intArrayOf(1)
//    val nums = intArrayOf()
    val len = Problem026().removeDuplicates(nums)

    for (i in 0 until len) {
        print("${nums[i]} ")
    }
    println()
}
