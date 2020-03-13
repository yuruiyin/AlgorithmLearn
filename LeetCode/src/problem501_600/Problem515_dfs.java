package problem501_600;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem515_dfs {

    private List<Integer> ansList;

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (ansList.size() == level) {
            ansList.add(root.val);
        }

        if (root.val > ansList.get(level)) {
            ansList.set(level, root.val);
        }

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        ansList = new ArrayList<>();
        dfs(root, 0);
        return ansList;
    }

}
