package kotlin_heros_practice3

import java.util.*

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()
    val arr = mutableListOf<Int>()
    for (i in 0 until n) {
        arr.add(scan.nextInt())
    }

    val visited = Array(1001) {false}
    val ansList = mutableListOf<Int>()

    for (i in n - 1 downTo 0) {
        if (visited[arr[i]]) {
            continue
        }

        visited[arr[i]] = true
        ansList.add(arr[i])
    }

    ansList.reverse()

    println(ansList.size)

    ansList.forEach {
        print("$it ")
    }
    println()
}