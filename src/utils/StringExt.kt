package utils

/**
 * 将含unicode编码的字符串(如/Storage/xxx/xxx/xxxx.jpg?auth_key\u003d123456)解码成含
 * 中文编码的字符串（如/Storage/xxx/xxx/xxxx.jpg?auth_key=123456）
 */
fun String.decodeUnicode2Cn(): String {
    val resSb = StringBuilder()
    var idx = 0
    while (idx < length) {
        val curChar = this[idx]
        if (curChar == '\\' && idx + 5 < length && this[idx + 1].toLowerCase() == 'u') {
            try {
                val cnChar = this.substring(idx + 2, idx + 6).toInt(16).toChar()
                resSb.append(cnChar)
                idx += 6
                continue
            } catch (e: Exception) {
                // do nothing
            }
        } else if (curChar == '\\' && idx + 6 < length && this[idx + 1] == '\\' &&
            this[idx + 2].toLowerCase() == 'u'
        ) {
            // 考虑两个\\的场景，如'?auth_key\\u330d123456'
            try {
                val cnChar = this.substring(idx + 3, idx + 7).toInt(16).toChar()
                resSb.append(cnChar)
                idx += 7
                continue
            } catch (e: Exception) {
                // do nothing
            }
        }
        resSb.append(curChar)
        idx++
    }
    return resSb.toString()
}

fun main() {
    val list = listOf(1, 3, 5).filter { it % 2 == 0 }
    println(list.size)
}

