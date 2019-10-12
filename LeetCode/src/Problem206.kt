import common.ListNode

/**
    反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
    进阶:
    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Problem206 {

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return head
        }

        var prevNode: ListNode? = null
        var curNode = head
        while (curNode != null) {
            val nextNode = curNode.next
            curNode.next = prevNode
            prevNode = curNode
            curNode = nextNode
        }

        return prevNode
    }

}

fun main(args: Array<String>) {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)

    val reversedListNode = Problem206().reverseList(head)

    var curNode = reversedListNode
    while (curNode != null) {
        println(curNode.`val`)
        curNode = curNode.next
    }

}