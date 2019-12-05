package problem501_600;

import common.TreeNode;

public class Problem538 {

    private int dfs(TreeNode root, int parentValue) {
        if (root == null) {
            return parentValue;
        }

        // 将父亲节点的新值传入到右子树中
        int rightSum = dfs(root.right, parentValue);
        root.val += rightSum; //更新当前节点
        return dfs(root.left, root.val); // 当前节点以及右子树的值都加到左子树上了。因此只要返回左子树的和即可
    }

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;
    }

}
