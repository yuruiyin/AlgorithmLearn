public class Problem002 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lastNextNode = null;
        ListNode resListNode = null;
        int carry = 0; // 进位
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            if (l2 != null) {
                l2Val = l2.val;
            }
            int sumTmp = l1Val + l2Val + carry;

            carry = sumTmp / 10;
            if (resListNode == null) {
                resListNode = new ListNode(sumTmp % 10);
                lastNextNode = resListNode;
            } else {
                lastNextNode.next = new ListNode(sumTmp % 10);
                lastNextNode = lastNextNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            lastNextNode.next = new ListNode(1);
        }
        return resListNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        ListNode l1 = new ListNode(5);
//        ListNode l2 = new ListNode(5);

//        ListNode l1 = new ListNode(1);
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(9);

//        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(4);
//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);

        ListNode resListNode = addTwoNumbers(l1, l2);
        while (resListNode != null) {
            System.out.print(resListNode.val);
            if (resListNode.next != null) {
                System.out.print(" -> ");
            }
            resListNode = resListNode.next;
        }
    }

}
