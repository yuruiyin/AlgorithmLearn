package problem001_100

import kotlin.math.abs

class Problem007 {

    fun reverse(x: Int): Int {
        val isNegative = x < 0
        val reversedStr = abs(x).toString().reversed()

        return try {
            if (isNegative) {
                -reversedStr.toInt()
            } else {
                reversedStr.toInt()
            }
        } catch (e: Exception) {
            0
        }
    }

}


data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

fun main(args: Array<String>) {
    println(Problem007().reverse(123456789))

    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
}
