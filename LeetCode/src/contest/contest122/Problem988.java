package contest.contest122;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem988 {

    public List<String> dfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        String cur = (char)(root.val + 'a') + "";

        if (root.left == null && root.right == null) {
            List<String> list = new ArrayList<>();
            list.add(cur);
            return list;
        }

        List<String> left = dfs(root.left);
        List<String> right = dfs(root.right);

        List<String> ansList = new ArrayList<>();

        for (String str: left) {
            ansList.add(str + cur);
        }

        for (String str: right) {
            ansList.add(str + cur);
        }

        return ansList;
    }

    public String smallestFromLeaf(TreeNode root) {
        List<String> ansList = dfs(root);
        Collections.sort(ansList);

        return ansList.get(0);
    }

    public static void main(String[] args) {
        System.out.println("b".compareTo("ba"));
    }

}
