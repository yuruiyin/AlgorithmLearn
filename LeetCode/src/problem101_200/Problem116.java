package problem101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem116 {

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

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            int size = nodeList.size();
            for (int i = 0; i < size; i++) {
                Node node = nodeList.get(i);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (i == size - 1) {
                    node.next = null;
                    continue;
                }
                node.next = nodeList.get(i+1);
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
    
}
