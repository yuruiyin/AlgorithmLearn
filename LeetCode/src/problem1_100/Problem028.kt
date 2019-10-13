package problem1_100

class Problem028 {

    fun strStr(haystack: String, needle: String): Int {
        val haystackLen = haystack.length
        val needleLen = needle.length

        if (needleLen > haystackLen) {
            return -1
        }

        if (needleLen == 0) {
            return 0
        }

        for (index in 0 until haystackLen) {
            val endIndex = index + needleLen
            if (endIndex > haystackLen) {
                return -1
            }

            val subStr = haystack.substring(index, endIndex)
            if (subStr == needle) {
                return index
            }
        }

        return -1
    }

}

fun main(args: Array<String>) {
    println(Problem028().strStr("hello", "ll"))
    println(Problem028().strStr("aabbaa", "bba"))
    println(Problem028().strStr("aaaaa", "bba"))
    println(Problem028().strStr("aaaaa", ""))
    println(Problem028().strStr("", ""))
    println(Problem028().strStr("a", "a"))
}
