package contest.contest149

class Problem1155 {

    private val ansMap = hashMapOf<String, Int>()

    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        if (d * f < target || target <= 0 || d == 0) {
            ansMap["$d,$target"] = 0
            return 0
        }

        if (d == 1 && f >= target) {
            ansMap["$d,$target"] = 1
            return 1
        }

        var res = 0
        for (i in 1..f) {
            val key = "${d-1},${target-i}"
            val next = if (ansMap.containsKey(key)) {
                ansMap[key]
            } else {
                numRollsToTarget(d - 1, f, target - i)
            }

            res = ((res + next!!) % (Math.pow(10.0, 9.0) + 7)).toInt()
        }

        ansMap["$d,$target"] = res

        return  res
    }

}

fun main(args: Array<String>) {
    println(Problem1155().numRollsToTarget(1, 6, 3))
    println(Problem1155().numRollsToTarget(2, 6, 7))
    println(Problem1155().numRollsToTarget(2, 5, 10))
    println(Problem1155().numRollsToTarget(1, 2, 3))
    println(Problem1155().numRollsToTarget(30, 30, 500))
    println(Problem1155().numRollsToTarget(2, 6, 6))
}
