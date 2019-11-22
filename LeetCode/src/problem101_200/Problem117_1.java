package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem117_1 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val , Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // 寻找右侧兄弟节点（可能不是第一个兄弟节点）的第一个子节点
    private Node findNextNodeFirstChild(Node root) {
        if (root.next == null) {
            return null;
        }

        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }

            if (root.next.right != null) {
                return root.next.right;
            }

            root = root.next;
        }

        return null;
    }

    // 寻找下一层的第一个节点
    private Node findFirstChild(Node root) {
        while (root != null) {
            if (root.left != null) {
                return root.left;
            }

            if (root.right != null) {
                return root.right;
            }

            root = root.next;
        }

        return null;
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Node queue = root;
        Node firstChild;

        while ((firstChild = findFirstChild(queue)) != null) {
            Node cur = queue;
            while (cur != null) {
                if (cur.left == null && root.right == null) {
                    cur = cur.next;
                }

                List<Node> nodeList = new ArrayList<>(); //最多就三个节点，当前左右子节点+子节点右侧第一个节点
                if (cur.left != null) {
                    nodeList.add(cur.left);
                }

                if (cur.right != null) {
                    nodeList.add(cur.right);
                }

                nodeList.add(findNextNodeFirstChild(cur));

                int size = nodeList.size();
                for (int i = 0; i < size - 1; i++) {
                    nodeList.get(i).next = nodeList.get(i+1);
                }

                cur = cur.next;
            }

            queue = firstChild;
        }

        return root;
    }
    
    public static void main(String[] args) {

    }

}
