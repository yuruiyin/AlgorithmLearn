package problem1_100

class Problem009 {

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }

        val numStr = x.toString()
        val len = numStr.length
        val end = len / 2
        for (i in 0..end) {
            if (numStr[i] != numStr[len - i - 1]) {
                return false
            }
        }

        return true
    }

}

fun main(args: Array<String>) {
    println(Problem009().isPalindrome(0))
    println(Problem009().isPalindrome(1))
    println(Problem009().isPalindrome(12))
    println(Problem009().isPalindrome(11))
    println(Problem009().isPalindrome(121))
    println(Problem009().isPalindrome(-121))
}
