package contest155

class Problem1200 {

    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()

        var minAbsDiff = Int.MAX_VALUE
        val size = arr.size

        for (i in 1 until size) {
            val absDiff = arr[i] - arr[i - 1]
            if (absDiff < minAbsDiff) {
                minAbsDiff = absDiff
            }
        }

        val ansList = mutableListOf<List<Int>>()
        for (i in 1 until size) {
            val absDiff = arr[i] - arr[i - 1]
            if (absDiff == minAbsDiff) {
                ansList.add(listOf(arr[i - 1], arr[i]))
            }
        }

        return ansList
    }

}

fun main(args: Array<String>) {
    println(Problem1200().minimumAbsDifference(intArrayOf(4, 2, 1, 3)))
    println(Problem1200().minimumAbsDifference(intArrayOf(1,3,6,10,15)))
    println(Problem1200().minimumAbsDifference(intArrayOf(3,8,-10,23,19,-4,-14,27)))

}
