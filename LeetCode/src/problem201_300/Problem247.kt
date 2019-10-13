package problem201_300

class Problem247 {

    private val singleNumList = mutableListOf("0", "1", "6", "8", "9")

    /**
     * 获取全排列列表
     */
    private fun fullPerm(n: Int, count: Int = 0): List<String> {
        if (n == 1) {
            return singleNumList
        }

        val resList = mutableListOf<String>()
        singleNumList.forEach { leftChar ->
            if (count == 0 && leftChar == "0") {
                // 全排列的第一位不能是0
                return@forEach
            }
            val rightList = fullPerm(n - 1, count + 1)
            val list = mutableListOf<String>()
            rightList.forEach { rightStr ->
                list.add(leftChar + rightStr)
            }
            resList.addAll(list)
        }

        return resList
    }

    /**
     * 获取字符串列表的右边对称另一半
     */
    private fun getRightHalfList(list: List<String>): List<String> {
        val rightHalfList = mutableListOf<String>()
        list.forEach {
            val reversedStr = it.reversed()
            val reversedStrList = reversedStr.toMutableList()
            val resReversedStrList = mutableListOf<Char>()
            reversedStrList.forEach {
                // 将 6换成9，9换成6
                val newChar = when (it) {
                    '6' -> '9'
                    '9' -> '6'
                    else -> it
                }
                resReversedStrList.add(newChar)
            }
            rightHalfList.add(resReversedStrList.joinToString(""))
        }

        return rightHalfList
    }

    private fun mergeList(leftList: List<String>, rightList: List<String>): List<String> {
        val resList = mutableListOf<String>()
        for ((index, leftValue) in leftList.withIndex()) {
            resList.add(leftValue + rightList[index])
        }
        return resList
    }

    /**
     * 往字符串列表的每个字符串中插入指定字符
     */
    private fun insertCharToStringList(list: List<String>, c: Char): List<String> {
        val resList = mutableListOf<String>()
        list.forEach { orignStr ->
            val strList = orignStr.toMutableList()
            strList.add(orignStr.length / 2, c)
            resList.add(strList.joinToString(""))
        }

        return resList
    }

    fun findStrobogrammatic(n: Int): List<String> {

        if (n == 1) {
            return listOf("0", "1", "8")
        }

        if (n == 2) {
            return listOf("11", "69", "88", "96")
        }

        if (n % 2 == 0) {
            // n为偶数, 求1、6、8、9的n/2位数的全排列。比如n=4，那么就求1、6、8、9的2位数的全排列，有4^2=16种
            val leftHalfList = fullPerm(n / 2)
            // 生成右边对称的另一半
            val rightHalfList = getRightHalfList(leftHalfList)
            return mergeList(leftHalfList, rightHalfList)
        }

        // n为奇数，字符串中间的数只能是1和8，也就是往n-1字符串列列表的每个字符串中间插入1或8得到新的字符串列表
        val evenList = findStrobogrammatic(n - 1)
        val resList = mutableListOf<String>()

        resList.addAll(insertCharToStringList(evenList, '0'))
        resList.addAll(insertCharToStringList(evenList, '1'))
        resList.addAll(insertCharToStringList(evenList, '8'))

        return resList
    }

}

fun main(args: Array<String>) {
    println(Problem247().findStrobogrammatic(1))
    println(Problem247().findStrobogrammatic(2))
    println(Problem247().findStrobogrammatic(3))
    println(Problem247().findStrobogrammatic(4))
    println(Problem247().findStrobogrammatic(5))
}
