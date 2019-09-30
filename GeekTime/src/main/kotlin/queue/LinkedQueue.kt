package queue

/**
 * 基于链表实现的队列
 */
class LinkedQueue {

    inner class ListNode(val value: String) {
        var next: ListNode? = null
    }

    private var head: ListNode? = null
    private var tail: ListNode? = null

    /**
     * 入队
     */
    fun enqueue(item: String): Boolean {
        val newNode = ListNode(item)
        if (tail == null) {
            head = newNode
            tail = newNode
        } else {
            tail?.next = newNode
            tail = tail?.next
        }

        return true
    }

    /**
     * 出队
     */
    fun dequeue(): String? {
        if (head == null) {
            return null
        }

        val resNodeValue = head?.value
        head = head?.next
        if (head == null) {
            tail = null
        }

        return resNodeValue
    }

}

fun main(args: Array<String>) {
    val linkedQueue = LinkedQueue()
    linkedQueue.enqueue("1")
    linkedQueue.enqueue("2")
    println(linkedQueue.dequeue())
    println(linkedQueue.dequeue())
    println(linkedQueue.dequeue())
}
