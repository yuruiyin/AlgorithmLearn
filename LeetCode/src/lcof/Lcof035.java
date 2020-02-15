package lcof;

import java.util.HashMap;
import java.util.Map;

public class Lcof035 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            oldToNewMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        for (Node oldNode : oldToNewMap.keySet()) {
            Node newNode = oldToNewMap.get(oldNode);
            newNode.next = oldToNewMap.get(oldNode.next);
            newNode.random = oldToNewMap.get(oldNode.random);
        }

        return oldToNewMap.get(head);
    }

}
