package problem301_400;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem366
 *
 * @author: yry
 * @date: 2020/4/7
 */
public class Problem366 {

    private List<List<Integer>> ansList;

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int depth = Math.max(dfs(root.left), dfs(root.right)) + 1;
        if (ansList.size() <= depth) {
            ansList.add(new ArrayList<>(Collections.singleton(root.val)));
        } else {
            ansList.get(depth).add(root.val);
        }
        return depth;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        // 求每个节点的高度
        ansList = new ArrayList<>();
        dfs(root);
        return ansList;
    }

}
