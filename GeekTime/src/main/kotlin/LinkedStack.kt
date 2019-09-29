/**
 * 基于链表实现的栈
 */
class LinkedStack {

    inner class ListNode(val value: String) {
        var next: ListNode? = null
    }

    private var top: ListNode? = null

    fun push(value: String): Boolean {
        val newNode = ListNode(value)

        if (top == null) {
            top = newNode
        } else {
            newNode.next = top
            top = newNode
        }

        return true
    }

    fun pop(): String? {
        if (top == null) {
            return null
        }

        val topValue = top?.value
        top = top?.next
        return topValue
    }

    fun peek(): String? {
        if (top == null) {
            return null
        }

        return top?.value
    }

}

fun main(args: Array<String>) {
    val linkedStack = LinkedStack()
    linkedStack.push("1")
    linkedStack.push("2")
    linkedStack.push("3")
    linkedStack.push("4")
    linkedStack.push("5")
    linkedStack.push("6")
    println(linkedStack.pop())
    linkedStack.pop()
    println(linkedStack.peek())
}
