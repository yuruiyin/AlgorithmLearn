package problem1_100

class Problem017 {

    private val map = hashMapOf<Char, String>().apply {
        this['2'] = "abc"
        this['3'] = "def"
        this['4'] = "ghi"
        this['5'] = "jkl"
        this['6'] = "mno"
        this['7'] = "pqrs"
        this['8'] = "tuv"
        this['9'] = "wxyz"
    }

    private fun dfs(digits: String, index: Int): List<String> {
        val curDigit = digits[index]

        if (index == digits.length - 1) {
            return map[curDigit]?.map {
                it + ""
            } ?: emptyList()
        }

        val resList = mutableListOf<String>()
        map[curDigit]?.forEach {curChar ->
            val curList = dfs(digits, index + 1).map {
                curChar + it
            }
            resList.addAll(curList)
        }

        return resList
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        return dfs(digits, 0)
    }

}

fun main(args: Array<String>) {
    val list = Problem017().letterCombinations("23")
    list.forEach {
        println(it)
    }
}
