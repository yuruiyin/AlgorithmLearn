package problem201_300

import common.ListNode

/**
    请判断一个链表是否为回文链表。

    示例 1:

    输入: 1->2
    输出: false
    示例 2:

    输入: 1->2->2->1
    输出: true
    进阶：
    你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/palindrome-linked-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Problem234 {

    /**
     * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。
     * 在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
     */
    fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }

        // 寻找链表中点
        var prev: ListNode? = null
        var slow: ListNode? = head
        var fast: ListNode? = head
        while (fast != null && fast.next != null) {
            fast = fast?.next?.next // 快指针走两步
            val next = slow?.next
            slow?.next = prev
            prev = slow
            slow = next // 慢指针走一步
        }

        // 如果fast指针为null，说明节点个数为偶数，否则则说明节点个数为奇数
        // 如果节点个数为奇数，则中间节点需要右移一步，即不考虑中间节点。此时slow节点就是中间节点
        var left = prev
        var right = slow
        if (fast != null) {
            right = right?.next
        }

        // 判断左右两个链表是否相等
        while (left != null && right != null) {
            if (left.`val` != right.`val`) {
                return false
            }

            left = left.next
            right = right.next
        }

        return true
    }

}

fun main(args: Array<String>) {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(1)
    println(Problem234().isPalindrome(head))
}
