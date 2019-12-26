package interview_google.round10;

public class Problem01 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    private Node getMostLeftNode(Node node) {
        Node ans = node;
        while (ans.left != null) {
            ans = ans.left;
        }
        return ans;
    }

    private Node getAccessorBigger(Node node, int target) {
        Node ans = node;
        while (ans != null && ans.val <= target) {
            ans = ans.parent;
        }
        return ans;
    }

    public Node inorderSuccessor(Node x) {
        if(x.right != null) {
            return getMostLeftNode(x.right);
        }

        return getAccessorBigger(x.parent, x.val);
    }

}
