package contest.contest169;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem02 {

    private List<Integer> ansList;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        ansList.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ansList = new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ansList);
        return ansList;
    }

}
