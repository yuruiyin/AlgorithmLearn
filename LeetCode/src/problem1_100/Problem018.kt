package problem1_100

class Problem018 {

    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val size = nums.size
        val resList = mutableListOf<List<Int>>()
        for (i in 0 until size - 3) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            for (j in i + 1 until size - 2) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue
                }
                var left = j + 1
                var right = size - 1
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {
                        left++
                        continue
                    }

                    if (right < size - 1 && nums[right] == nums[right + 1]) {
                        right--
                        continue
                    }

                    val sum = nums[i] + nums[j] + nums[left] + nums[right]

                    if (sum == target) {
                        resList.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--
                        continue
                    }

                    if (sum > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
        }

        return resList
    }

}

fun main(args: Array<String>) {
    val arr = intArrayOf(1, 0, -1, 0, -2, 2)
    val resList = Problem018().fourSum(arr, 0)

    resList.forEach {list ->
        list.forEach {
            print("$it ")
        }
        println()
    }
}
