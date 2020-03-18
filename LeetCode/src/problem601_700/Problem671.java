package problem601_700;

import common.TreeNode;

import java.util.TreeSet;

/**
 * Problem671
 *
 * @author: yry
 * @date: 2020/3/16
 */
public class Problem671 {

    private void dfs(TreeSet<Integer> treeSet, TreeNode root) {
        if (root == null) {
            return;
        }

        treeSet.add(root.val);
        dfs(treeSet, root.left);
        dfs(treeSet, root.right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        dfs(treeSet, root);
        if (treeSet.size() <= 1) {
            return -1;
        }

        treeSet.pollFirst();
        return treeSet.first();
    }

}
