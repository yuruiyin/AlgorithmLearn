class Problem292 {

    fun canWinNim(n: Int): Boolean {
        return n % 4 != 0
    }

}

fun main(args: Array<String>) {
    println(Problem292().canWinNim(4))
}
