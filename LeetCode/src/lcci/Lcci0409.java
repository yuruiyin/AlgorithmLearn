package lcci;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lcci0409 {

    private List<List<Integer>> ansList;

    private void dfs(TreeNode cur, List<TreeNode> nodeList, List<Integer> path) {
        if (cur.left != null) {
            nodeList.add(cur.left);
        }

        if (cur.right != null) {
            nodeList.add(cur.right);
        }

        if (nodeList.isEmpty()) {
            ansList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nodeList.size(); i++) {
            List<TreeNode> nextNodeList = new ArrayList<>(nodeList);
            nextNodeList.remove(i);
            TreeNode next = nodeList.get(i);
            path.add(next.val);
            dfs(nodeList.get(i), nextNodeList, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> BSTSequences(TreeNode root) {
        ansList = new ArrayList<>();
        if (root == null) {
            ansList.add(new ArrayList<>());
            return ansList;
        }
        dfs(root, new ArrayList<>(), new ArrayList<>(Collections.singleton(root.val)));
        return ansList;
    }

}
