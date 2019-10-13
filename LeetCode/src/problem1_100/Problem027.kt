package problem1_100

class Problem027 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }

        nums.sort()

        val size = nums.size
        var firstIndex = -1
        var count = 0
        for ((index, value) in nums.withIndex()) {
            if (value != `val`) {
                continue
            }

            if (index == 0 || nums[index - 1] != `val`) {
                firstIndex = index
            }
            count++
        }

        if (firstIndex == -1) {
            return nums.size
        }

        val beginRemoveIndex = firstIndex + count

        if (beginRemoveIndex >= size) {
            return nums.size - count
        }

        for (i in beginRemoveIndex until size) {
            nums[i - count] = nums[i]
        }

        return nums.size - count
    }

}

fun main(args: Array<String>) {
//    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
//    val nums = intArrayOf(3, 2, 2, 3)
//    val nums = intArrayOf(1)
    val nums = intArrayOf()
    val len = Problem027().removeElement(nums, 3)

    for (i in 0 until len) {
        print("${nums[i]} ")
    }
    println()
}
