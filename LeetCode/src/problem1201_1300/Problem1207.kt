
class Problem1207 {

    fun uniqueOccurrences(arr: IntArray): Boolean {
        val countMap = HashMap<Int, Int>()
        val isExistArr = arrayOfNulls<Int>(1001)

        arr.forEach {
            if (countMap.containsKey(it)) {
                countMap[it] = countMap[it]?.plus(1) ?: 0
            } else {
                countMap[it] = 1
            }
        }

        countMap.values.forEach {
            if (isExistArr[it] != null) {
                return false
            }
            isExistArr[it] = 1
        }

        return true
    }

}

fun main(args: Array<String>) {
    val arr = intArrayOf(-3,0,1,-3,1,1,1,-3,10,0)
    println(Problem1207().uniqueOccurrences(arr))
}
