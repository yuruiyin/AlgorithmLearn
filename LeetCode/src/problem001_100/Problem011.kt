package problem001_100

class Problem011 {

    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1

        var maxArea = 0

        while (left < right) {
            val curArea = (right - left) * Math.min(height[left], height[right])
            if (curArea > maxArea) {
                maxArea = curArea
            }

            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return  maxArea
    }

}

fun main(args: Array<String>) {
    var heightArr = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(Problem011().maxArea(heightArr))
}
