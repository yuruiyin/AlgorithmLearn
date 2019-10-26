package contest.contest156

import java.lang.StringBuilder

class Problem1209 {
    fun removeDuplicates(s: String, k: Int): String {
        val len = s.length

        if (len <= 1) {
            return s
        }

        val list = s.toMutableList()

        var count = 1

        var fromIndex = -1
        var toIndex = -1
        for (i in 0 until len) {
            if (i > 0 && list[i] == list[i - 1]) {
                count++

                if (count == k) {
                    fromIndex = i - (k - 1)
                    toIndex = i
                    break
                }
            } else {
                count = 1
            }
        }

        val newList = mutableListOf<Char>()

        if (fromIndex != -1 && toIndex != -1) {
            list.forEachIndexed { index, c ->
                if (index !in fromIndex..toIndex) {
                    newList.add(c)
                }
            }

            val stringBuilder = StringBuilder()
            newList.forEach {
                stringBuilder.append(it)
            }
            return removeDuplicates(stringBuilder.toString(), k)
        } else {
            return s
        }

    }
}

fun main(args: Array<String>) {
    println(Problem1209().removeDuplicates("abcd", 2))
    println(Problem1209().removeDuplicates("deeedbbcccbdaa", 3))
    println(Problem1209().removeDuplicates("pbbcggttciiippooaais", 2))
    println(Problem1209().removeDuplicates("p", 2))
}
