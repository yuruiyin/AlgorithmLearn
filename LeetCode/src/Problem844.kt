import java.util.*

/**
    给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
class Problem844 {

    private fun insertToStack(str: String, stack: Stack<Char>) {
        str.forEach {
            if (it != '#') {
                stack.push(it)
            } else {
                if (stack.isNotEmpty()) {
                    stack.pop()
                }
            }
        }
    }

    /**
     * 思路，可以使用栈来实现，遇到“#”，就执行pop操作
     */
    fun backspaceCompare(S: String, T: String): Boolean {
        val stackS = Stack<Char>()
        val stackT = Stack<Char>()

        insertToStack(S, stackS)
        insertToStack(T, stackT)

        // 判断两个栈的元素是否相等
        if (stackS.size != stackT.size) {
            return false
        }

        val size = stackS.size
        for (i in 0 until size) {
            if (stackS[i] != stackT[i]) {
                return false
            }
        }

        return true
    }

}

fun main(args: Array<String>) {
    println(Problem844().backspaceCompare("ab#c", "ad#c"))
    println(Problem844().backspaceCompare("ab##", "c#d#"))
    println(Problem844().backspaceCompare("a##c", "#a#c"))
    println(Problem844().backspaceCompare("a#c", "b"))
}
