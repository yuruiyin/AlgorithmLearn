package doubleContest.round26;

import common.TreeNode;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/16
 */
public class C {

    private int ansCount = 0;

    private void dfs(TreeNode root, int maxVal) {
        if (root == null) {
            return;
        }

        if (maxVal <= root.val) {
            ansCount++;
            maxVal = root.val;
        }

        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }

    public int goodNodes(TreeNode root) {
        dfs(root, (int) -1e5);
        return ansCount;
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
