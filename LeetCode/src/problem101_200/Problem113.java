package problem101_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {

    private List<List<Integer>> ansList;

    private void backTrack(TreeNode root, int sum, List<Integer> pathList) {
        if (root == null) {
            return;
        }

        pathList.add(root.val);
        if (root.left == null && root.right == null) {
            // 叶子
            if (sum == root.val) {
                ansList.add(new ArrayList<>(pathList));
            }
            pathList.remove(pathList.size() - 1);
            return;
        }

        backTrack(root.left, sum - root.val, pathList);
        backTrack(root.right, sum - root.val, pathList);

        pathList.remove(pathList.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }

        backTrack(root, sum, new ArrayList<>());
        return ansList;
    }
    
    public static void main(String[] args) {

    }
    
}
