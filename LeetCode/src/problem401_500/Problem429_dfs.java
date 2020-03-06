package problem401_500;

import java.util.ArrayList;
import java.util.List;

public class Problem429_dfs {

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

    private List<List<Integer>> ansList;

    private void dfs(Node root, int level) {
        if (ansList.size() <= level) {
            ansList.add(new ArrayList<>());
        }

        ansList.get(level).add(root.val);

        for (Node child : root.children) {
            dfs(child, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ansList = new ArrayList<>();
        dfs(root, 0);
        return ansList;
    }

}
