package problem201_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {

    private List<String> ansList;

    private String listToStr(List<Integer> pathList) {
        StringBuilder sb = new StringBuilder();
        int size = pathList.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(pathList.get(i)).append("->");
        }
        sb.append(pathList.get(size - 1));
        return sb.toString();
    }

    private void dfs(TreeNode root, List<Integer> pathList) {
        if (root.left == null && root.right == null) {
            pathList.add(root.val);
            ansList.add(listToStr(pathList));
            pathList.remove(pathList.size() - 1);
            return;
        }

        pathList.add(root.val);
        if (root.left != null) {
            dfs(root.left, pathList);
        }

        if (root.right != null) {
            dfs(root.right, pathList);
        }

        pathList.remove(pathList.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ansList = new ArrayList<>();
        dfs(root, new ArrayList<>());
        return ansList;
    }

}
