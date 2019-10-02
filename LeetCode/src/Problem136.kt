class Problem136 {

    fun singleNumber(nums: IntArray): Int {
        return nums.reduce { acc, value -> acc xor value }
    }

}

fun main(args: Array<String>) {
    println(Problem136().singleNumber(intArrayOf(2, 2, 1)))
    println(Problem136().singleNumber(intArrayOf(4, 1, 2, 1, 2)))
}