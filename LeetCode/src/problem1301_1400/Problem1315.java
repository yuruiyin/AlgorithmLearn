package problem1301_1400;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem1315 {

    private int sum = 0;

    private void dfs(TreeNode root, List<Integer> nodeList) {
        if (root == null) {
            return;
        }

        nodeList.add(root.val);
        int nodeSize = nodeList.size();
        if (nodeSize >= 3 && nodeList.get(nodeSize - 3) % 2 == 0) {
            sum += root.val;
        }

        dfs(root.left, nodeList);
        dfs(root.right, nodeList);

        nodeList.remove(nodeList.size() - 1);
    }

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, new ArrayList<>());
        return sum;
    }

}
