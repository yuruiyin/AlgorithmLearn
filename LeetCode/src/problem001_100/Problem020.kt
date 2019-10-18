package problem001_100

import java.util.*

class Problem020 {

    fun isValid(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }

        val stack = Stack<Char>()

        for (c in s) {
            if (c == '(' || c == '{' || c == '[') {
                stack.add(c)
            } else {
                if (stack.isEmpty()) {
                    return false
                }

                if (c == ')' && stack.peek() != '(') {
                    return false
                }

                if (c == '}' && stack.peek() != '{') {
                    return false
                }

                if (c == ']' && stack.peek() != '[') {
                    return false
                }

                stack.pop()
            }
        }

        return stack.isEmpty()
    }

}

fun main(args: Array<String>) {
    println(Problem020().isValid("()"))
    println(Problem020().isValid("()[]{}"))
    println(Problem020().isValid("(]"))
    println(Problem020().isValid("([)]"))
    println(Problem020().isValid("{[]}"))
}
