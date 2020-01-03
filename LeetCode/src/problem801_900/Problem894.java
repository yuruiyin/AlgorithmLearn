package problem801_900;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem894 {

    private List<TreeNode> dfs(int n) {
        if (n == 1) {
            List<TreeNode> list = new ArrayList<>();
            list.add(new TreeNode(0));
            return list;
        }

        List<TreeNode> ansList = new ArrayList<>();

        for (int i = 1; i < n - 1; i+=2) {
            List<TreeNode> leftList = dfs(i);
            List<TreeNode> rightList = dfs(n - i - 1);
            for (TreeNode left : leftList) {
                for (TreeNode right: rightList) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    ansList.add(root);
                }
            }
        }

        return ansList;
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return dfs(n);
    }

}
