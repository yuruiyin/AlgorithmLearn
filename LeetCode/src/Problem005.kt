class Problem005 {

    fun longestPalindrome(s: String): String {

        if (s.isEmpty()) {
            return ""
        }

        val len = s.length - 1
        var maxLen = 1
        var start = 0
        var end = 0

        val hashMap = HashMap<Char, MutableList<Int>>()

        s.forEachIndexed { index, c ->
            if (!hashMap.containsKey(c)) {
                hashMap[c] = mutableListOf()
            }

            hashMap[c]?.add(index)
        }

        for (left in 0 until len) {
            if (len - left + 1 <= maxLen) {
                break
            }

            val leftChar = s[left]
            val rightMin = left + maxLen

            val sameCharIndexList = hashMap[leftChar]?.asSequence()?.filter {
                it >= rightMin
            }?.toList()

            if (sameCharIndexList == null || sameCharIndexList.isEmpty()) {
                continue
            }

            val size = sameCharIndexList.size

            for (i in size - 1 downTo 0) {
                val right = sameCharIndexList[i]
                var leftIndex = left + 1
                var rightIndex = right - 1
                var isBackStr = true
                while (rightIndex >= leftIndex) {
                    if (s[leftIndex] != s[rightIndex]) {
                        isBackStr = false
                        break
                    }

                    leftIndex++
                    rightIndex--
                }

                if (isBackStr) {
                    maxLen = right - left + 1
                    start = left
                    end = right
                    break
                }
            }

        }

        if (maxLen == 1) {
            return s[0].toString()
        }

        return s.substring(start, end + 1)
    }
}

fun main(args: Array<String>) {
    println(Problem005().longestPalindrome("babad"))
}








