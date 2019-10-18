package problem001_100

class Problem010 {

    fun isMatch(s: String, p: String): Boolean {
        val sReversed = s.reversed()
        val pReversed = p.reversed()

        val sLen = sReversed.length
        val pLen = pReversed.length
        var i = 0
        var pStart = 0
        while (i < sLen) {
            val curSubS = StringBuilder(sReversed[i].toString())
            var nextI = i
            for (j in i + 1 until sLen) {
                if (sReversed[j] != sReversed[i]) {
                    break
                }
                nextI = j
                curSubS.append(sReversed[j])
            }

            if (pStart >= pLen) {
                return false
            }

            // 寻找最长的正则串
            var curSubPEndIndex = pStart
            val curSubPStartIndex = pStart
            for (k in pStart until pLen) {
                if (pReversed[k] in 'a'..'z' && pReversed[k] != curSubS[0]) {
                    // 找到第一个不等于当前要处理的s重复子串（如'ppp'）的字符
                    if (k == curSubPStartIndex) {
                        return false
                    }
                    pStart = k
                    if (pReversed[k - 1] == '*') {
                        pStart--
                        curSubPEndIndex--
                    }
                    break
                }
                pStart++
                curSubPEndIndex++
            }

            if (curSubPEndIndex == pLen) {
                curSubPEndIndex = pLen - 1
            }

            val curSubP = pReversed.substring(curSubPStartIndex, curSubPEndIndex)


            i  = nextI + 1
        }

        return true
    }

}

fun main(args: Array<String>) {

}
