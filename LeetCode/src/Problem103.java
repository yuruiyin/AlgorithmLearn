import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem103 {

    private void binaryTree(TreeNode root, List<List<Integer>> lists, int layer) {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);


        List<List<Integer>> ansLists = new Problem103().zigzagLevelOrder(root);

        for (int i = 0; i < ansLists.size(); i++) {
            for (int j = 0; j < ansLists.get(i).size(); j++) {
                System.out.print(ansLists.get(i).get(j) + " ");
            }

            System.out.println();
        }
    }

}
