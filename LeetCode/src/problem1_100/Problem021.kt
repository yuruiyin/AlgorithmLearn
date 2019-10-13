package problem1_100

import common.ListNode

class Problem021 {

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        }

        if (l2 == null) {
            return l1
        }

        val list = mutableListOf<Int>()
        list.add(l1.`val`)
        var curNext = l1.next
        while (curNext != null) {
            list.add(curNext.`val`)
            curNext = curNext.next
        }

        list.add(l2.`val`)
        curNext = l2.next
        while (curNext != null) {
            list.add(curNext.`val`)
            curNext = curNext.next
        }

        if (list.isEmpty()) {
            return null
        }

        list.sort()

        val resListNode = ListNode(list[0])
        val size = list.size
        var curNode = resListNode
        for (i in 1 until size) {
            curNode.next = ListNode(list[i])
            curNode = curNode.next!!
        }

        return resListNode
    }

}

fun main(args: Array<String>) {
    val l1 = ListNode(1)
    l1.next = ListNode(2)
    l1.next?.next = ListNode(4)
    val l2 = ListNode(1)
    l2.next = ListNode(3)
    l2.next?.next = ListNode(4)
    val resListNode = Problem021().mergeTwoLists(l1, l2)
    if (resListNode == null) {
        println("")
        return
    }

    print(resListNode.`val`)
    var curNext = resListNode.next
    while (curNext != null) {
        print("->${curNext.`val`}")
        curNext = curNext.next
    }
}
