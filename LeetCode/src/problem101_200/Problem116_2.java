package problem101_200;

public class Problem116_2 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val ,Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 直接采用next来当queue， 然后进行BFS
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node queue = root;

        while (queue.left != null) {
            Node cur = queue;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }

            queue = queue.left;
        }

        return root;
    }

    public static void main(String[] args) {

    }
    
}
