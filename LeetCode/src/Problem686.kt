import java.lang.StringBuilder

class Problem686 {

    fun repeatedStringMatch(A: String, B: String): Int {
        if (A.contains(B)) {
            return 1
        }

        val sb = StringBuilder(A)
        var ans = B.length / A.length
        if (B.length % A.length != 0) {
            ans++
        }

        for (i in 1 until ans) {
            sb.append(A)
        }

        if (sb.contains(B)) {
            return ans
        }

        sb.append(A)
        ans++
        if (sb.contains(B)) {
            return ans
        }

        return -1
    }

}

fun main(args: Array<String>) {
    println(Problem686().repeatedStringMatch("abcd", "cdabcdabcda"))
}
