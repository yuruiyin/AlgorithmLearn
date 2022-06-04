package problem1101_1200

class Problem1119_kt {
    val set = setOf('a', 'e', 'i', 'o', 'u')
    fun removeVowels(s: String): String {
        return s.filter { !set.contains(it) }
    }
}

fun main(args: Array<String>) {
    println("hello")
}