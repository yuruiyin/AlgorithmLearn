package problem1_100

/**
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);
    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
 */

class Problem006 {

    fun convert(s: String, numRows: Int): String {

        if (s.isEmpty() || numRows <= 0) {
            return ""
        }

        if (s.length <= numRows || numRows == 1) {
            return s
        }

        val resultSb = StringBuilder()
        val firstLineOffset = 2 * numRows - 2

        val strLen = s.length

        for (lineNum in 0 until numRows) {
            var offset = firstLineOffset - 2 * lineNum
            if (offset == 0) {
                // 最后一行
                offset = firstLineOffset
            }
            val firstCharInCurLine = s[lineNum]
            var curCharIndex = lineNum
            resultSb.append(firstCharInCurLine)
            while (curCharIndex + offset <= strLen - 1) {
                curCharIndex += offset
                resultSb.append(s[curCharIndex])
                if (offset != 0 && offset != firstLineOffset) {
                    offset = firstLineOffset - offset
                }
            }
        }

        return resultSb.toString()
    }
}

fun main(args: Array<String>) {
    println(Problem006().convert("A", 1))
}


