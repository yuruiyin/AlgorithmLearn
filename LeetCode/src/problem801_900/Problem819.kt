package problem801_900

class Problem819 {

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        return paragraph.toLowerCase()
            .replace("[^a-zA-Z]".toRegex(), " ")
            .split("\\s+".toRegex())
            .filter {
                !banned.contains(it) && it.isNotBlank()
            }
            .groupBy {
                it
            }
            .mapValues { it.value.size }
            .maxBy{ it.value }
            ?.key ?: throw Exception()
    }

}

fun main(args: Array<String>) {
    //"..Bob hit a ball, the hit BALL flew far after it was hit."
    //["hit"]
    println(Problem819().mostCommonWord("..Bob hit a ball, the hit BALL flew far after it was hit.", arrayOf("hit")))
}