package problem301_400;

import common.ListNode;

public class Problem382 {

    // TODO 未通过，据说是蓄水池抽样算法。还没搞懂。
    class Solution {

        private ListNode head;
        private ListNode curNode;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            curNode = this.head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            if (curNode == null) {
                curNode = head;
            }

            int value = curNode.val;
            curNode = curNode.next;
            return value;
        }
    }
    
    public static void main(String[] args) {

    }
    
}
