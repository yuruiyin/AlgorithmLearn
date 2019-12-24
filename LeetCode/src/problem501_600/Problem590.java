package problem501_600;

import java.util.ArrayList;
import java.util.List;

public class Problem590 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private List<Integer> ansList;

    private void doPostOrder(Node root) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child: root.children) {
                doPostOrder(child);
            }
        }

        ansList.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        ansList = new ArrayList<>();
        doPostOrder(root);
        return ansList;
    }

}
