package problem801_900

import java.util.*

class Problem862 {

    /**
     * 维护前缀和数组P和一个存放下标x0,x1,...的双端队列，保证P[x0], P[x1]...单调递增。
     */
    fun shortestSubarray(A: IntArray, K: Int): Int {
        val size = A.size
        val P = Array(size + 1, {0})

        for (i in 0 until size) {
            P[i + 1] = P[i] + A[i]
        }

        var minLen = size + 1
        val deque = LinkedList<Int>()

        for (i in 0 until P.size) {
            // 若x1 < x2 而且P[x2] <= P[x1]，那么x1可以不考虑了。
            while (deque.isNotEmpty() && P[i] <= P[deque.last]) {
                deque.removeLast()
            }

            // 计算最小值，从队首取数据进行比较，若满足要求，则删除队首。
            // 为什么要从队首开始比呢，因为P是一个单调递增数列，满足条件的肯能是在队首开始的那段。
            while (deque.isNotEmpty() && P[i] >= P[deque.first] + K) {
                minLen = Math.min(minLen, i -  deque.removeFirst())
            }

            deque.addLast(i)
        }

        return if (minLen < size + 1) {
            minLen
        } else {
            -1
        }

    }

}

fun main(args: Array<String>) {
    println(Problem862().shortestSubarray(intArrayOf(1), 1))                     // 1
    println(Problem862().shortestSubarray(intArrayOf(1, 2), 4))                  // -1
    println(Problem862().shortestSubarray(intArrayOf(2, -1, 2), 3))              // 3
    println(Problem862().shortestSubarray(intArrayOf(3, 2, 4, 6), 10))           // 2
    println(Problem862().shortestSubarray(intArrayOf(56, -21, 56, 35, -9), 61))  // 2
    println(Problem862().shortestSubarray(intArrayOf(84, -37, 32, 40, 95), 167)) // 3
    println(Problem862().shortestSubarray(intArrayOf(-28, 81, -20, 28, -29), 89))// 3

    println(Problem862().shortestSubarray(intArrayOf(-34, 37, 51, 3, -12, -50, 51, 100), 151))

}
