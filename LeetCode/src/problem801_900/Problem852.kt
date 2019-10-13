package problem801_900
class Problem852 {

    fun peakIndexInMountainArray(A: IntArray): Int {
        val size = A.size
        var ansIndex = -1
        for (i in 1 until size) {
            if (A[i] < A[i - 1] && ansIndex == -1) {
                if (i == 1) {
                    return -1
                }

                ansIndex = i - 1
            } else if (ansIndex != -1 && A[i] >= A[i - 1]) {
                return -1
            }
        }

        return ansIndex
    }

}

fun main(args: Array<String>) {
    println(Problem852().peakIndexInMountainArray(intArrayOf(0, 1, 0, 0)))
    println(Problem852().peakIndexInMountainArray(intArrayOf(0, 2, 1, 0, 2)))
}
