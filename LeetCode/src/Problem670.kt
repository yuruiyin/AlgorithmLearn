
class Problem670 {

    fun maximumSwap(num: Int): Int {
        val list = num.toString().toMutableList()
        val size = list.size

        for (left in 0 until size - 1) {
            var maxNum = list[left]
            var ansRightIndex = -1
            for (right in size - 1 downTo left + 1) {
                if (list[right] > maxNum) {
                    ansRightIndex = right
                    maxNum = list[right]
                }
            }

            if (ansRightIndex != -1) {
                val tmp = list[left]
                list[left] = list[ansRightIndex]
                list[ansRightIndex] = tmp
                break
            }
        }

        return list.joinToString("").toInt()

    }

}

fun main(args: Array<String>) {
    println(Problem670().maximumSwap(2736))
    println(Problem670().maximumSwap(9973))
    println(Problem670().maximumSwap(2737))
    println(Problem670().maximumSwap(0))
}
