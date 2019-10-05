package interview_alibaba.round01;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);

        if (root.children != null && !root.children.isEmpty()) {
            for (Node children : root.children) {
                list.addAll(preorder(children));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node node5 = new Node(5, null);
        Node node6 = new Node(6, null);
        List<Node> list3 = new ArrayList<>();
        list3.add(node5);
        list3.add(node6);
        Node node3 = new Node(3, list3);
        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        List<Node> list1 = new ArrayList<>();
        list1.add(node3);
        list1.add(node2);
        list1.add(node4);
        Node root = new Node(1, list1);

        List<Integer> ansList = new Problem01().preorder(root);

        ansList.forEach(value -> {
            System.out.print(value + " ");
        });
    }

}
