public class Problem147 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode curNode = head;

        while (curNode != null && curNode.next != null) {
            ListNode nextNode = curNode.next;
            ListNode nextNextNode = nextNode.next;

            if (nextNode.val >= curNode.val) {
                curNode = curNode.next;
                continue;
            }

            // 插入到第一个元素
            if (nextNode.val <= head.val) {
                nextNode.next = head;
                curNode.next = nextNextNode;
                head = nextNode;
                continue;
            }

            ListNode tmpNode = head;
            while (tmpNode != null && tmpNode.next != nextNode) {
                if (nextNode.val <= tmpNode.next.val) {
                    ListNode oldNextNode = tmpNode.next;
                    tmpNode.next = nextNode;
                    nextNode.next = oldNextNode;
                    break;
                }

                tmpNode = tmpNode.next;
            }

            curNode.next = nextNextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new Problem147.ListNode(4);
        head.next = new Problem147.ListNode(2);
        head.next.next = new Problem147.ListNode(1);
        head.next.next.next = new Problem147.ListNode(3);

        ListNode sortedListNode = new Problem147().insertionSortList(head);

        ListNode curNode = sortedListNode;
        while (curNode != null) {
            System.out.print(curNode.val + " ");
            curNode = curNode.next;
        }
    }

}
