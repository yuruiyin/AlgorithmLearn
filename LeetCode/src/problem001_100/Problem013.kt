package problem001_100

class Problem013 {

    fun romanToInt(s: String): Int {
        val map = mutableMapOf<Char, Int>()

        map['I'] = 1
        map['V'] = 5
        map['X'] = 10
        map['L'] = 50
        map['C'] = 100
        map['D'] = 500
        map['M'] = 1000

        val map2 = mutableMapOf<String, Int>()

        map2["IV"] = 4
        map2["IX"] = 9
        map2["XL"] = 40
        map2["XC"] = 90
        map2["CD"] = 400
        map2["CM"] = 900

        var i = 0
        val len = s.length
        var res = 0
        while (i < len) {
            if (i < len - 1) {
                val key = "${s[i]}${s[i + 1]}"
                if (map2.containsKey(key)) {
                    res += (map2[key] ?: 0)
                    i += 2
                } else {
                    res += (map[s[i]] ?: 0)
                    i++
                }
            } else {
                res += (map[s[i]] ?: 0)
                i++
            }
        }

        return res
    }

}

fun main(args: Array<String>) {
    println(Problem013().romanToInt("III"))
    println(Problem013().romanToInt("IV"))
    println(Problem013().romanToInt("IX"))
    println(Problem013().romanToInt("LVIII"))
    println(Problem013().romanToInt("MCMXCIV"))

}
