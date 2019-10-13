package problem301_400

import java.util.*

/**
    给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 */
class Problem346(val size: Int) {

    private val queue = LinkedList<Int>()

    fun next(`val`: Int): Double {
        if (queue.size == size) {
            queue.pollLast()
        }

        queue.push(`val`)

        return queue.sum() * 1.0 / queue.size
    }

}

fun main(args: Array<String>) {
    val m = Problem346(3)
    println(m.next(1))
    println(m.next(10))
    println(m.next(3))
    println(m.next(5))
}
