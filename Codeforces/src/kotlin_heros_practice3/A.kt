package kotlin_heros_practice3

import java.util.*

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)
    val arr = mutableListOf<Int>()
    arr.add(0, scan.nextInt())
    arr.add(1, scan.nextInt())
    arr.add(2, scan.nextInt())
    arr.add(3, scan.nextInt())

    arr.sort();

    val b = (arr[0] - arr[1] + arr[2]) / 2
    val a = arr[0] - b
    val c = arr[1] - a

    println("$a $b $c")
}