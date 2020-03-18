package interview_2020;

import common.TreeNode;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class A {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmpRight = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(tmpRight);
        return root;
    }

}
