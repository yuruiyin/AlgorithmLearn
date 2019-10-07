package interview_facebook.round01;

public class Problem01 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;

        while (curNode != null && curNode.next != null) {
            ListNode tmpNode = curNode.next;
            while (tmpNode != null) {
                if (tmpNode.val == curNode.val) {
                    curNode.next = curNode.next.next;
                    tmpNode = tmpNode.next;
                } else {
                    break;
                }
            }

            curNode = curNode.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);


        ListNode ansListNode = new Problem01().deleteDuplicates(head);

        ListNode curNode = ansListNode;
        while (curNode != null) {
            System.out.print(curNode.val + "->");
            curNode = curNode.next;
        }

    }

}
