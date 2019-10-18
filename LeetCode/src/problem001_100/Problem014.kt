package problem001_100

class Problem014 {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }

        val firstStr = strs[0]
        val resStr = StringBuilder("")
        for ((index, c) in firstStr.withIndex()) {
            for (str in strs) {
                if (index >= str.length) {
                    return resStr.toString()
                }

                if (str[index] == c) {
                    continue
                }

                return resStr.toString()
            }

            resStr.append(c)
        }

        return resStr.toString()
    }

}

fun main(args: Array<String>) {
    var array = arrayOf("flower","flow","flight")
    println(Problem014().longestCommonPrefix(array))

    array = arrayOf("dog","racecar","car")
    println(Problem014().longestCommonPrefix(array))
}
