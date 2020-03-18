import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * LintCode097
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode480 {

    private List<String> ansList;

    private String listToStr(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    private void dfs(TreeNode root, List<String> tmpList) {
        if (root == null) {
            return;
        }

        tmpList.add(String.valueOf(root.val));
        tmpList.add("->");

        if (root.left == null && root.right == null) {
            ansList.add(listToStr(tmpList));
            tmpList.remove(tmpList.size() - 1);
            tmpList.remove(tmpList.size() - 1);
            return;
        }

        dfs(root.left, tmpList);
        dfs(root.right, tmpList);
        tmpList.remove(tmpList.size() - 1);
        tmpList.remove(tmpList.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ansList = new ArrayList<>();
        dfs(root, new ArrayList<>());
        return ansList;
    }

}
