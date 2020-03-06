package problem401_500;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem429 {

    class Node {
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

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);

        List<List<Integer>> ansList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                list.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            ansList.add(list);
        }

        return ansList;
    }

}
