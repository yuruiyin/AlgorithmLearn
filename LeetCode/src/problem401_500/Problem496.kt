package problem401_500

/**
    给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
    nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/next-greater-element-i
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem496 {

    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val list = mutableListOf<Int>()
        nums1.forEach {
            val len2 = nums2.size
            var resIndex = -1
            for (i in 0 until len2) {
                if (it == nums2[i]) {
                    resIndex = i
                    break
                }
            }

            if (resIndex == -1) {
                list.add(-1)
                return@forEach
            }

            // 找到相等的
            var isFound = false
            for (i in resIndex until len2) {
                if (nums2[i] > it) {
                    list.add(nums2[i])
                    isFound = true
                    break
                }
            }

            if (!isFound) {
                list.add(-1)
            }
        }

        return list.toIntArray()
    }

}

fun main(args: Array<String>) {
    var resIntArr = Problem496().nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
    resIntArr.forEach {
        print("$it ")
    }

    resIntArr = Problem496().nextGreaterElement(intArrayOf(2, 4), intArrayOf(1, 2, 3, 4))
    resIntArr.forEach {
        print("$it ")
    }
}
