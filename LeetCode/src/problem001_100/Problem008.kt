package problem001_100

class Problem008 {

    fun myAtoi(str: String): Int {
        val newStr = str.trim()
        if (newStr == "") {
            return 0
        }

        val firstChar = newStr[0]
        if (!(firstChar == '+' || firstChar == '-' || firstChar in '0'..'9')) {
            return 0
        }

        var firstIndex = 0
        if (firstChar == '+' || firstChar == '-') {
            firstIndex = 1
        }

        var res: Long = 0
        val strLen = newStr.length
        for (i in firstIndex until strLen) {
            val value = newStr[i]
            if (value == '+' || value == '-' || value !in '0'..'9') {
                break
            }

            res = res * 10 + (value - '0')

            if (firstChar == '-' && -res < Int.MIN_VALUE) {
                return Int.MIN_VALUE
            }

            if (firstChar != '-' && res > Int.MAX_VALUE) {
                return Int.MAX_VALUE
            }
        }

        if (firstChar == '-') {
            res = -res
        }
        return res.toInt()
    }

}

fun main(args: Array<String>) {
    println(Problem008().myAtoi(""))
    println(Problem008().myAtoi("-"))
    println(Problem008().myAtoi("+"))
    println(Problem008().myAtoi("42"))
    println(Problem008().myAtoi("-42"))
    println(Problem008().myAtoi("4193 with words"))
    println(Problem008().myAtoi("words and 987"))
    println(Problem008().myAtoi("-91283472332"))
    println(Problem008().myAtoi("-+2"))
    println(Problem008().myAtoi("+-2"))
    println(Problem008().myAtoi("-42+"))

}
