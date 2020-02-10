package problem901_1000;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Problem993 {

    class Data {
        int depth;
        TreeNode parent;
        Data(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    private Map<Integer, Data> map;

    private void dfs(TreeNode root, int val, TreeNode parent, int depth) {
        if (root == null) {
            return;
        }

        if (root.val == val) {
            map.put(val, new Data(depth, parent));
        }

        dfs(root.left, val, root, depth + 1);
        dfs(root.right, val, root, depth + 1);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        map = new HashMap<>();
        dfs(root, x, null, 0);
        dfs(root, y, null, 0);

        if (!map.containsKey(x) || !map.containsKey(y)) {
            return false;
        }

        Data dataX = map.get(x);
        Data dataY = map.get(y);
        return dataX.depth == dataY.depth && dataX.parent != dataY.parent;
    }

}
