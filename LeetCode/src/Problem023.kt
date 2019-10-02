class Problem023 {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) {
            return null
        }

        val ansList = mutableListOf<Int>()

        while (true) {
            var minValue = Int.MAX_VALUE
            var minNodeIndex = -1
            for ((index, node) in lists.withIndex()) {
                if (node != null && node.`val` < minValue) {
                    minValue = node.`val`
                    minNodeIndex = index
                }
            }

            if (minNodeIndex == -1) {
                // 说明所有的链表都已遍历完了
                break
            }

            ansList.add(minValue)
            lists[minNodeIndex] = lists[minNodeIndex]?.next
        }

        if (ansList.isEmpty()) {
            return null
        }

        val ansNode = ListNode(ansList[0])
        val size = ansList.size
        var curNode: ListNode? = ansNode
        for (i in 1 until size) {
            curNode?.next = ListNode(ansList[i])
            curNode = curNode?.next
        }

        return ansNode
    }

}

fun main(args: Array<String>) {
    val listNode1: ListNode? = ListNode(1)
    listNode1?.next = ListNode(4)
    listNode1?.next?.next = ListNode(5)

    val listNode2: ListNode? = ListNode(1)
    listNode2?.next = ListNode(3)
    listNode2?.next?.next = ListNode(4)

    val listNode3: ListNode? = ListNode(2)
    listNode3?.next = ListNode(6)

    val lists = arrayOf(listNode1, listNode2, listNode3)

    val ansNode = Problem023().mergeKLists(lists)
    var curNode = ansNode
    while (curNode != null) {
        println(curNode.`val`)
        curNode = curNode.next
    }
}
