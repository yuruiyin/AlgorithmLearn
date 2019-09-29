/**
 * 基于数组实现的栈
 */
class ArrayStack(private val size: Int = 0) {

    private val items by lazy {
        arrayOfNulls<String>(size)
    }

    private var count = 0

    fun push(item: String): Boolean {
        if (count == size) {
           return false
        }

        items[count] = item
        count++
        return true
    }

    fun pop(): String? {
        if (count == 0) {
            return null
        }

        val res = items[count - 1]
        count--
        return res
    }

    fun peek(): String? {
        if (count == 0) {
            return null
        }

        return items[count - 1]
    }

}

fun main(args: Array<String>) {
    val arrayStack = ArrayStack(6)
    arrayStack.push("1")
    arrayStack.push("2")
    arrayStack.push("3")
    arrayStack.push("4")
    arrayStack.push("5")
    arrayStack.push("6")
    println(arrayStack.pop())
    arrayStack.pop()
    println(arrayStack.peek())
}
