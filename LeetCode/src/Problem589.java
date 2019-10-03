import java.util.ArrayList;
import java.util.List;

public class Problem589 {
    static class Node {
        public int val;
        public List<Problem589.Node> children;

        public Node() {}

        public Node(int _val,List<Problem589.Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Problem589.Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        if (root.children != null && !root.children.isEmpty()) {
            for (Problem589.Node children : root.children) {
                list.addAll(preorder(children));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Problem589.Node node5 = new Problem589.Node(5, null);
        Problem589.Node node6 = new Problem589.Node(6, null);
        List<Problem589.Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);
        Problem589.Node node3 = new Problem589.Node(3, list3);
        Problem589.Node node2 = new Problem589.Node(2, null);
        Problem589.Node node4 = new Problem589.Node(4, null);
        List<Problem589.Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);
        Problem589.Node root = new Problem589.Node(1, list1);

        List<Integer> ansList = new Problem589().preorder(root);

        ansList.forEach(value -> {
            System.out.print(value + " ");
        });
    }
}
