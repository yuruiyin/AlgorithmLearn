import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem144 {

    /**
     * 非递归（迭代)方法来实现二叉树的前序遍历
     * 思路：使用到栈。每次取出栈顶元素加入结果列表，先将栈顶元素的右子节点（如果有的话）压栈，再压左子节点。如此循环，知道栈为空。
     * @param root
     * @param ansList
     */
    private void preorderByIterator(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();

            ansList.add(top.val);

            if (top.right != null) {
                stack.push(top.right);
            }

            if (top.left != null) {
                stack.push(top.left);
            }
        }

    }

    private void preorder(TreeNode root, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        ansList.add(root.val);

        if (root.left != null) {
            preorder(root.left, ansList);
        }

        if (root.right != null) {
            preorder(root.right, ansList);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
//        preorder(root, ansList);
        preorderByIterator(root, ansList);
        return ansList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> ansList = new Problem144().preorderTraversal(root);

        for (Integer num: ansList) {
            System.out.print(num + ", ");
        }
    }

}
