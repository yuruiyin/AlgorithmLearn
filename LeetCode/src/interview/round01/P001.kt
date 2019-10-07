package interview.round01

class P001 {

    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val newLicensePlate = licensePlate.toLowerCase()

        val map = hashMapOf<Char, Int>()
        newLicensePlate.forEach {
            if (it in 'a'..'z') {
                if (map.containsKey(it)) {
                    map[it] = map[it]!! + 1
                } else {
                    map[it] = 1
                }
            }
        }

        val targetWordIndexList = mutableListOf<Int>()
        words.forEachIndexed { index, word ->
            val wordMap = hashMapOf<Char, Int>()
            word.forEach { c ->
                if (wordMap.containsKey(c)) {
                    wordMap[c] = wordMap[c]!! + 1
                } else {
                    wordMap[c] = 1
                }
            }

            var hasContain = true
            for (key in map.keys) {
                if (!wordMap.containsKey(key) || wordMap[key]!! < map[key]!!) {
                    hasContain = false
                    break
                }
            }

            if (hasContain) {
                targetWordIndexList.add(index)
            }
        }

        if (targetWordIndexList.isEmpty()) {
            return ""
        }

        val len = targetWordIndexList.size
        var targetWord =  words[targetWordIndexList[0]]
        var minLen = targetWord.length

        for (i in 0 until len) {
            val index = targetWordIndexList[i]
            if (words[index].length < minLen) {
                minLen = words[index].length
                targetWord = words[index]
            }
        }

        return targetWord
    }

}

fun main(args: Array<String>) {
    println(P001().shortestCompletingWord("1s3 PSt", arrayOf("step", "steps", "stripe", "stepple")))
    println(P001().shortestCompletingWord("1s3 456", arrayOf("looks", "pest", "stew", "show")))
    println(P001().shortestCompletingWord("tR28607", arrayOf("present","fall","make","change","everything","performance","owner","beat","name","serve")))
}
