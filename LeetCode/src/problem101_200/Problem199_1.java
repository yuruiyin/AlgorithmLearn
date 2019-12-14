package problem101_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem199_1 {

    private void dfs(TreeNode root, int level, List<Integer> ansList) {
        if (root == null) {
            return;
        }

        // 因为先右子树，后左子树的，因此如果有右子树，那么就考虑右子树，否则考虑左子树
        if (ansList.size() == level) {
            ansList.add(root.val);
        }

        // 先遍历右子树，后遍历左子树
        dfs(root.right, level + 1, ansList);
        dfs(root.left, level + 1, ansList);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        dfs(root, 0, ansList);
        return ansList;
    }

}
