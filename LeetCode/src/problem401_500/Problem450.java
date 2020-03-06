package problem401_500;

import common.TreeNode;

public class Problem450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            // 若右子树不为空，则用右子树的最小节点取代当前节点
            if (root.right != null) {
                TreeNode cur = root.right;
                TreeNode parent = root;
                while (cur.left != null) {
                    parent = cur;
                    cur = cur.left;
                }

                // cur.left == null, cur就是右子树最小的节点
                if (parent != root) {
                    parent.left = cur.right;
                    cur.right = root.right;
                } else {
                    cur.right = root.right.right;
                }

                cur.left = root.left;
                return cur;
            } else {
                return root.left;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

}
