package problem101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem116_1 {

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

    private void dfs(Node root) {
        if (root.left == null) {
            // 叶子节点, 已经由父节点处理过了
            return;
        }

        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        dfs(root.left);
        dfs(root.right);
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        dfs(root);
        return root;
    }

    public static void main(String[] args) {

    }
    
}
