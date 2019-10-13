package problem101_200;

import common.TreeNode;

import java.util.*;

public class Problem145 {

    private void postOrderIterator(TreeNode root, List<Integer> ansList) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        Map<TreeNode, Boolean> isAddedMap = new HashMap<>();

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            while (!stack.isEmpty()) {
                TreeNode top = stack.peek();
                if (top.right != null && !isAddedMap.containsKey(top.right)) {
                    curr = top.right;
                    break;
                }

                stack.pop();
                ansList.add(top.val);
                isAddedMap.put(top, true);
            }
        }
    }

    private void postOrderRecursive(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrderRecursive(root.left, ansList);
        }

        if (root.right != null) {
            postOrderRecursive(root.right, ansList);
        }

        ansList.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
//        postOrderRecursive(root, ansList);
        postOrderIterator(root, ansList);
        return ansList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        
        List<Integer> ansList = new Problem145().postorderTraversal(root);
        
        for (Integer num: ansList) {
            System.out.print(num + ",");
        }
        
        System.out.println();
    }

}
