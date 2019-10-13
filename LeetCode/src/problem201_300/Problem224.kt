package problem201_300

import java.lang.Exception
import java.util.*

/**
    实现一个基本的计算器来计算一个简单的字符串表达式的值。
    字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 */
class Problem224 {

    /**
     * 计算只有"+","-"和数字的栈中的算术表达式的值
     */
    private fun calcStack(stack: Stack<String>): Int {
        // 计算stack2中的算术表达式
        var res = 0
        var curOperator = "+"
        while (stack.isNotEmpty()) {
            val top = stack.pop()
            if (top == "+" || top == "-") {
                curOperator = top
            } else {
                // 数字
                if (curOperator == "+") {
                    res += top.toInt()
                } else {
                    res -= top.toInt()
                }
            }
        }

        return res
    }

    /**
     * 思路：遇到一个右括号，然后就pop直到找到最近的左括号，并将这对括号之间的数和运算符压到另外一个栈stack2中
     * 在stack2中计算完结果，再压如到原先的栈中。
     * 按照上面的操作一直执行，直到没有括号位置，最后，将stack1中的元素全部pop然后依次push到stack2中，计算出结果即可
     * 注意：需要忽略空格
     */
    fun calculate(s: String): Int {
        val stack1 = Stack<String>()
        val stack2 = Stack<String>()

        s.forEach {
            if (it == ' ') {
                return@forEach
            }

            if (it == ')') {
                while (stack1.isNotEmpty()) {
                    val top = stack1.pop()
                    if (top == "(") {
                        break
                    }

                    stack2.push(top)
                }

                // 计算stack2中的算术表达式
                stack1.push(calcStack(stack2).toString())

            } else if (it == '(' || it == '+' || it == '-') {
                stack1.push(it.toString())
            } else {
                // 数字
                try {
                    val top = stack1.peek().toInt()
                    // 当前栈顶是数字，则应该就是两位以上的数字
                    stack1.pop()
                    stack1.push((top * 10 + (it - '0')).toString())
                } catch (e: Exception) {
                    // 当前栈顶不是数字
                    stack1.push(it.toString())
                }
            }
        }

        // 计算之后没有括号的stack1中的算术表达式的值
        while (stack1.isNotEmpty()) {
            stack2.push(stack1.pop())
        }
        return calcStack(stack2)
    }

}

fun main(args: Array<String>) {
    println(Problem224().calculate("1 + 1"))
    println(Problem224().calculate(" 2-1 + 2 "))
    println(Problem224().calculate("(1+(4+5+2)-3)+(6+8)"))
    println(Problem224().calculate(" 2-10 + 2 "))
    println(Problem224().calculate("(1+(40+5+2)-3)+(6+8)"))

}
