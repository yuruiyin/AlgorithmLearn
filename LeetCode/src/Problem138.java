import java.util.HashMap;
import java.util.Map;

public class Problem138 {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cursor = head;
        while (cursor != null) {
            Node clone = new Node(cursor.val, null, null);
            map.put(cursor, clone);
            cursor = cursor.next;
        }

        cursor = head;
        while (cursor != null) {
            map.get(cursor).next = map.get(cursor.next);
            map.get(cursor).random = map.get(cursor.random);
            cursor = cursor.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.val = 1;
        Node secondNode = new Node();
        head.next = secondNode;
        head.random = secondNode;
        secondNode.val = 2;
        secondNode.random = secondNode;

        Node copyNode = new Problem138().copyRandomList(head);
    }
    
}
