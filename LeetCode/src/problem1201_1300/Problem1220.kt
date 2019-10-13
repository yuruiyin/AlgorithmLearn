
class Problem04 {

    companion object {
        const val MOD = 1000000007
    }

    private val countMap by lazy {
        hashMapOf<String, Long>()
    }

    private fun getCount(n: Int, c: Char): Long {
        if (n == 1) {
            countMap["$n$c"] = 1
            return 1
        }

        var sum: Long = 0
        val nextCList = when (c) {
            'a' -> listOf('e', 'i', 'u')
            'e' -> listOf('a', 'i')
            'i' -> listOf('e', 'o')
            'o' -> listOf('i')
            'u' -> listOf('i', 'o')
            else -> emptyList()
        }

        nextCList.forEach {
            val key = "${n-1}$it"
            val count = if (countMap.containsKey(key)) {
                countMap[key]
            } else {
                getCount(n - 1, it)
            }

            countMap[key] = count!!

            sum += count
        }

        countMap["$n$c"] = sum

        return sum % MOD
    }

    /**
     * 递归解法会导致StackOverFlowError
     */
    fun countVowelPermutationRecursive(n: Int): Int {
        var sum: Long = 0
        listOf('a', 'e', 'i', 'o', 'u').forEach {
            sum = (sum + getCount(n, it)) % MOD
        }
        return (sum % MOD).toInt()
    }

    fun countVowelPermutation(n: Int): Int {
        // dp代表以某个字符为结尾的字符串个数
        val dp = mutableListOf<Long>(1, 1, 1, 1, 1)
        val oldDp = mutableListOf<Long>()

        var i = 0
        while (++i < n) {
            oldDp.clear()
            oldDp.addAll(dp)
            dp[0] = (oldDp[1] + oldDp[2] + oldDp[4]) % MOD
            dp[1] = (oldDp[0] + oldDp[2]) % MOD
            dp[2] = (oldDp[1] + oldDp[3]) % MOD
            dp[3] = oldDp[2] % MOD
            dp[4] = (oldDp[2] + oldDp[3]) % MOD
        }

        return (dp.reduce { acc, l -> acc + l } % MOD).toInt()
    }

}

fun main(args: Array<String>) {
    println(Problem04().countVowelPermutationRecursive(1))
    println(Problem04().countVowelPermutationRecursive(2))
    println(Problem04().countVowelPermutationRecursive(5))
    println(Problem04().countVowelPermutationRecursive(500))
}

