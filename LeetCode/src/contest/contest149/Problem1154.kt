package contest.contest149

class Problem1154 {

    private val list = mutableListOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    private fun isLeapYear(year: Int): Boolean {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
    }

    fun ordinalOfDate(date: String): Int {
        val year = date.substring(0, 4).toInt()
        val isLeap = isLeapYear(year)

        val month = date.substring(5, 7).toInt()
        val day = date.substring(8, 10).toInt()

        var res = 0

        for (i in 0 until month - 1) {
            res += list[i]
        }

        if (isLeap && month > 2) {
            res += 1
        }

        res += day

        return res
    }

}

fun main(args: Array<String>) {
    println(Problem1154().ordinalOfDate("2019-01-09"))
    println(Problem1154().ordinalOfDate("2019-02-10"))
    println(Problem1154().ordinalOfDate("2003-03-01"))
    println(Problem1154().ordinalOfDate("2004-03-01"))
}
