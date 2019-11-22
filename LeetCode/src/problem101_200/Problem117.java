package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem117 {

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

    private void dfs(Node root) {
        if (root == null || root.left == null && root.right == null) {
            // 空 或 叶子节点, 由上一层父节点处理过了
            return;
        }

        List<Node> nodeList = new ArrayList<>(); // 最多涉及三个节点，即当前节点左右节点 + 兄弟节点的第一个子节点
        if (root.left != null) {
            nodeList.add(root.left);
        }

        if (root.right != null) {
            nodeList.add(root.right);
        }

        Node next = findNextNodeFirstChild(root);
        if (next != null) {
            nodeList.add(next);
        }

        int size = nodeList.size();
        for (int i = 0; i < size - 1; i++) {
            nodeList.get(i).next = nodeList.get(i+1);
        }

        //一定要先右边再左边，也就是要先完善右侧节点的所有next节点，这样上面findNextNodeFirstChild才可以正常工作。
        dfs(root.right);
        dfs(root.left);
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
