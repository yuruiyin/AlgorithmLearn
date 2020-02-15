package lcof;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Lcof034 {

    private List<List<Integer>> ansList;

    private int getPathSum(List<Integer> pathList) {
        int ans = 0;
        for (Integer num : pathList) {
            ans += num;
        }
        return ans;
    }

    private void dfs(TreeNode root, int sum, List<Integer> pathList) {
        pathList.add(root.val);
        if (root.left == null && root.right == null) {
            int pathSum = getPathSum(pathList);
            if (pathSum == sum) {
                ansList.add(new ArrayList<>(pathList));
            }
            pathList.remove(pathList.size() - 1);

            return;
        }

        if (root.left != null) {
            dfs(root.left, sum, pathList);
        }

        if (root.right != null) {
            dfs(root.right, sum, pathList);
        }

        pathList.remove(pathList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }

        dfs(root, sum, new ArrayList<>());
        return ansList;
    }

}
