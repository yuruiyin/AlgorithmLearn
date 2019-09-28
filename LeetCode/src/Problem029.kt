class Problem029 {

    fun divide(dividend: Int, divisor: Int): Int {
        if (divisor == 1) {
            return dividend
        }

        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        val signDiff = (dividend > 0) xor (divisor > 0)
        var t = Math.abs(dividend.toLong())
        val d = Math.abs(divisor.toLong())

        var result = 0

        for (i in 31 downTo 0) {
            if ((t shr i) >= d) {
                result += 1 shl i
                t -= d shl i
            }
        }

        return if (signDiff) {
            -result
        } else {
            result
        }
    }

}

fun main(args: Array<String>) {
    val res = Problem029().divide(-2147483648, 2)
    println("res: $res")
}
