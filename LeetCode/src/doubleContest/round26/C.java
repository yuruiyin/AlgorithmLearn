package doubleContest.round26;

import common.TreeNode;
import utils.TreeMultiSet;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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

}
