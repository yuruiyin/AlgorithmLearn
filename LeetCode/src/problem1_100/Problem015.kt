package problem1_100

class Problem015 {

    fun find(nums: IntArray, from: Int, to: Int, value: Int): Int {
        if (to < from) {
            return -1
        }

        var l = from
        var r = to

        while (l <= r) {
            val mid = l + (r - l) / 2
            val midValue = nums[mid]
            when {
                midValue > value -> r = mid - 1
                midValue < value -> l = mid + 1
                else -> return mid
            }
        }

        return -1
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return listOf()
        }

        val size = nums.size
        nums.sort()

        var notNegativeNumIndex = -1
        for ((index, num) in nums.withIndex()) {
            if (num >= 0) {
                notNegativeNumIndex = index
                break
            }
        }

        if (notNegativeNumIndex == -1) {
            return listOf()
        }

        if (notNegativeNumIndex == 0) {
            return if (nums[2] == 0) {
                listOf(listOf(0, 0, 0))
            } else {
                listOf()
            }
        }

        val resList = mutableListOf<List<Int>>()
        for (i in 0 until notNegativeNumIndex) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            val curNegativeNumAbs = Math.abs(nums[i])

            var kFromIndex = notNegativeNumIndex
            for (j in size - 1 downTo notNegativeNumIndex) {
                if (kFromIndex > j - 1) {
                    break
                }
                if (nums[j] <= curNegativeNumAbs) {
                    val resThirdNum = curNegativeNumAbs - nums[j]
                    val resThirdNumIndex = find(nums, kFromIndex, j - 1, resThirdNum)
                    if (resThirdNumIndex != -1) {
                        resList.add(listOf(nums[i], nums[resThirdNumIndex], nums[j]))
                        kFromIndex = resThirdNumIndex + 1
                    }
//                    for (k in j - 1 downTo notNegativeNumIndex) {
//                        if (nums[k] == resThirdNum) {
//                            resList.add(listOf(nums[i], nums[k], nums[j]))
//                            break
//                        }
//                    }
                }
            }
        }

        var positiveNumIndex = -1
        for ((index, num) in nums.withIndex()) {
            if (num > 0) {
                positiveNumIndex = index
                break
            }
        }

        if (positiveNumIndex == -1) {
            return resList
        }

        for (i in size - 1 downTo positiveNumIndex) {
            if (i < size - 1 && nums[i] == nums[i + 1]) {
                continue
            }
            val curPositiveNum = nums[i]

            var kToIndex = notNegativeNumIndex - 1
            for (j in 0 until notNegativeNumIndex) {
                if (kToIndex < j + 1) {
                    break
                }
                if (Math.abs(nums[j]) < curPositiveNum) {
                    val resThirdNum = -curPositiveNum - nums[j]
                    val resThirdNumIndex = find(nums, j + 1, kToIndex, resThirdNum)
                    if (resThirdNumIndex != -1) {
                        resList.add(listOf(nums[j], nums[resThirdNumIndex], nums[i]))
                        kToIndex = resThirdNumIndex - 1
                    }
//                    for (k in j + 1 until notNegativeNumIndex) {
//                        if (nums[k] == resThirdNum) {
//                            resList.add(listOf(nums[j], nums[k], nums[i]))
//                            break
//                        }
//                    }
                }
            }
        }

        // 处理 0 0 0的情况
        if (size - notNegativeNumIndex >= 3 && nums[notNegativeNumIndex] == 0
                && nums[notNegativeNumIndex + 1] == 0 && nums[notNegativeNumIndex + 2] == 0) {
            resList.add(listOf(0, 0, 0))
        }

        // 出重
        val map = hashMapOf<String, Boolean>()
        val newList = mutableListOf<List<Int>>()
        resList.forEach {
            val key = "${it[0]},${it[1]},${it[2]}"
            if (!map.containsKey(key)) {
                newList.add(it)
                map[key] = true
            }
        }

        return newList
    }

}

fun main(args: Array<String>) {
    val nums = intArrayOf(-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0)

    val resList = Problem015().threeSum(nums)
    resList.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}
