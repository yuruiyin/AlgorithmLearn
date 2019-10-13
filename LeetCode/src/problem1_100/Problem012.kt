package problem1_100

class Problem012 {

    fun intToRoman(num: Int): String {
        val list = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)

        val map = hashMapOf<Int, String>()
        map[1] = "I"
        map[4] = "IV"
        map[5] = "V"
        map[9] = "IX"
        map[10] = "X"
        map[40] = "XL"
        map[50] = "L"
        map[90] = "XC"
        map[100] = "C"
        map[400] = "CD"
        map[500] = "D"
        map[900] = "CM"
        map[1000] = "M"

        var res = StringBuilder()
        val size = list.size
        var num2 = num
        for (i in size - 1 downTo 0) {
            var multiple: Int = num2 / list[i]
            if (multiple <= 0) {
                continue
            }

            while (multiple-- > 0) {
                res.append(map[list[i]])
            }

            num2 %= list[i]
        }

        return res.toString()
    }

}

fun main(args: Array<String>) {
    println(Problem012().intToRoman(3))
    println(Problem012().intToRoman(4))
    println(Problem012().intToRoman(9))
    println(Problem012().intToRoman(58))
    println(Problem012().intToRoman(1994))

}