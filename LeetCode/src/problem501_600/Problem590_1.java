package problem501_600;

import java.util.ArrayList;
import java.util.List;

public class Problem590_1 {


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


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        if (root.children != null) {
            for (Node child: root.children) {
                list.addAll(postorder(child));
            }
        }

        list.add(root.val);
        return list;
    }

}
