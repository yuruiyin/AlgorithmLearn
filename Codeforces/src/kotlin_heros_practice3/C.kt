package kotlin_heros_practice3

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val fileName = scan.next()
    val arr = fileName.toCharArray()
    var xCount = 0
    var ans = 0;

    for (i in 0 until n) {
        if (arr[i] == 'x') {
            xCount++
        } else {
            if (xCount > 2) {
                ans += xCount - 2
            }
            xCount = 0
        }
    }

    if (xCount > 2) {
        ans += xCount - 2
    }

    println(ans)
}