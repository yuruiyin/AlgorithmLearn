import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode376
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode376 {

    private List<List<Integer>> ansList;
    private int target;

    private void dfs(TreeNode root, int sum, List<Integer> tmpList) {
        if (root == null) {
            return;
        }

        sum += root.val;
        tmpList.add(root.val);
        if (root.left == null && root.right == null) {
            // 叶子
            if (sum == target) {
                ansList.add(new ArrayList<>(tmpList));
            }
            tmpList.remove(tmpList.size() - 1);
            return;
        }

        dfs(root.left, sum, tmpList);
        dfs(root.right, sum, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        ansList = new ArrayList<>();
        this.target = target;
        dfs(root, 0, new ArrayList<>());
        return ansList;
    }

}
