
class Problem1208 {

    fun getMaxLength(diffList: List<Int>, maxCost: Int): Int {
        var cost = 0
        var res = 0

        diffList.forEach {
            cost += it
            if (cost <= maxCost) {
                res++
            } else {
                return res
            }
        }

        return res
    }

    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val diffList = mutableListOf<Int>()

        val len = s.length

        for (i in 0 until len) {
            diffList.add(Math.abs(s[i] - t[i]))
        }

//        diffList.sort()

        var maxLen = 0

        for (i in 0 until len) {
            val subList = diffList.subList(i, len)
            val tpmMaxLen = getMaxLength(subList, maxCost)
            if (tpmMaxLen > maxLen) {
                maxLen = tpmMaxLen
            }
        }

        return maxLen
    }
}

fun main(args: Array<String>) {
    val s = "abcd"
    val t = "bcdf"
    val maxCost = 3

//    val s = "abcd"
//    val t = "cdef"
//    val maxCost = 3

//    val s = "krrgw"
//    val t = "zjxss"
//    val maxCost = 19

    println(Problem1208().equalSubstring(s, t, maxCost))
}
