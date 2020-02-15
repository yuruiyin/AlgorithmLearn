package lcof;

public class Lcof036 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    private Node getMinNode(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node getMaxNode(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    class Result {
        Node minNode;
        Node maxNode;
        Result(Node minNode, Node maxNode) {
            this.minNode = minNode;
            this.maxNode = maxNode;
        }
    }

    private Result inorder(Node root) {
        if (root == null) {
            return null;
        }

        Result leftRes = inorder(root.left);
        if (leftRes != null) {
            leftRes.maxNode.right = root;
            root.left = leftRes.maxNode;
        }

        Result rightRes = inorder(root.right);
        if (rightRes != null) {
            root.right = rightRes.minNode;
            rightRes.minNode.left = root;
        }

        Node resMinNode = leftRes != null ? leftRes.minNode : root;
        Node resMaxNode = rightRes != null ? rightRes.maxNode : root;
        return new Result(resMinNode, resMaxNode);
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node minNode = getMinNode(root);
        Node maxNode = getMaxNode(root);

        inorder(root);
        minNode.left = maxNode;
        maxNode.right = minNode;

        return minNode;
    }

}
