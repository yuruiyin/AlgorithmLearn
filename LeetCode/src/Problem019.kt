

class Problem019 {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        var size = 1

        var curNode = head
        while (curNode?.next != null) {
            size++
            curNode = curNode.next
        }

        val willRemovedIndex = size - n

        if (willRemovedIndex == 0) {
            return head.next
        }

        curNode = head
        var index = 0
        while (curNode?.next != null) {
            if (index == willRemovedIndex - 1) {
                if (index == size - 2) {
                    curNode.next = null
                } else {
                    curNode.next = curNode.next?.next
                }

                return head
            }

            index++
            curNode = curNode.next
        }

        return null
    }

}

fun main(args: Array<String>) {
    val head = Problem019.ListNode(1)
    head.next = Problem019.ListNode(2)
    head.next?.next = Problem019.ListNode(3)
    head.next?.next?.next = Problem019.ListNode(4)
    head.next?.next?.next?.next = Problem019.ListNode(5)

    val resHead = Problem019().removeNthFromEnd(head, 4)

    var curNode = resHead
    while (true) {
        curNode?.let {
            print("${it.`val`}->")
        }

        if (curNode?.next == null) {
            break
        }

        curNode = curNode.next
    }

}
