package problem1301_1400;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1305_3 {

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ansList = new ArrayList<>();
        dfs(root1, ansList);
        dfs(root2, ansList);
        Collections.sort(ansList);
        return ansList;
    }

}
