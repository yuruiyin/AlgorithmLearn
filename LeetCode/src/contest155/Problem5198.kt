package contest155

/**
 * TODO 第155场周赛 第2道题
 */
class Problem5198 {

    private fun gcd(m: Int, n: Int): Int {
        if (n == 0) {
            return m
        }

        return gcd(n, m % n)
    }

    private fun getLeastCommonMultiple(m: Int, n: Int): Long {
        return m.toLong() * n / gcd(m, n)
    }

    private fun getAnsOfTwoNumbers(n: Int, list: List<Int>): Int {
        if (list[1] % list[0] == 0) {
            return list[0] * n
        }

        val lcm = getLeastCommonMultiple(list[0], list[1])

        val count1 = lcm / list[0]
        val count2 = lcm / list[1]

        val lcmIndex = count1 + count2 - 1
        val x = n / lcmIndex
        val mod = x % lcmIndex

        val initCount = list[1] / list[0]

        return -1
    }

    private fun getAnsOfThreeNumbers(n: Int, list: List<Int>): Int {
        return -1
    }

    fun nthUglyNumber(n: Int, a: Int, b: Int, c: Int): Int {
        val set = mutableSetOf(a, b, c)
        val list = set.toMutableList()
        list.sort()

        return when (list.size) {
            1 -> {
                list[0] * n
            }
            2 -> {
                getAnsOfTwoNumbers(n, list)
            }
            else -> {
                getAnsOfThreeNumbers(n, list)
            }
        }
    }
}

fun main(args: Array<String>) {

    println(Problem5198().nthUglyNumber(2, 2, 4, 3))
}

