import java.util.ArrayList;
import java.util.List;

public class Problem103 {

    public static class TreeNode {
        int val;
        Problem103.TreeNode left;
        Problem103.TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private void binaryTree(Problem103.TreeNode root, List<List<Integer>> lists, int layer) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        if (root.left != null) {
            list.add(root.left.val);
        }

        if (root.right != null) {
            list.add(root.right.val);
        }

        if (!list.isEmpty()) {
            if (layer < lists.size()) {
                lists.get(layer).addAll(list);
            } else {
                lists.add(list);
            }
        }

        binaryTree(root.left, lists, layer + 1);
        binaryTree(root.right, lists, layer + 1);

    }

    public List<List<Integer>> zigzagLevelOrder(Problem103.TreeNode root) {
        List<List<Integer>> ansLists = new ArrayList<>();
        if (root == null) {
            return ansLists;
        }
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        ansLists.add(rootList);
        binaryTree(root, ansLists, 1);

        for (int i = 1; i < ansLists.size(); i+=2) {
            List<Integer> newList = new ArrayList<>();
            for (int j = ansLists.get(i).size() - 1; j >= 0; j--) {
                newList.add(ansLists.get(i).get(j));
            }

            ansLists.remove(i);
            ansLists.add(i, newList);
        }
        return ansLists;
    }

    public static void main(String[] args) {
        Problem103.TreeNode root = new Problem103.TreeNode(1);
        root.left = new Problem103.TreeNode(2);
        root.right = new Problem103.TreeNode(3);
        root.left.left = new Problem103.TreeNode(4);
        root.right.right = new Problem103.TreeNode(5);
        root.left.left.left = new Problem103.TreeNode(6);
        root.left.left.right = new Problem103.TreeNode(8);
        root.right.right.left = new Problem103.TreeNode(7);


        List<List<Integer>> ansLists = new Problem103().zigzagLevelOrder(root);

        for (int i = 0; i < ansLists.size(); i++) {
            for (int j = 0; j < ansLists.get(i).size(); j++) {
                System.out.print(ansLists.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }

}
