package fall_2022;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class D {

    private Map<Long, Integer> memoMap;

    private int dfs(TreeNode cur, int flag, int flagOneLevel) {
        if (cur == null) {
            return 0;
        }

//        long key = (long) cur.hashCode() * 10 + flag * 10L + flagOneLevel;
//        long key = flag * 10L * Integer.MAX_VALUE + (long) flagOneLevel * Integer.MAX_VALUE + cur.hashCode();
        long key = (flag + 1) * 10L * Integer.MAX_VALUE + (long) (flagOneLevel + 1) * Integer.MAX_VALUE + cur.hashCode();
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        if ((cur.val ^ flag ^ flagOneLevel) == 0) {
            // 当前灯已经关了
            int res1 = dfs(cur.left, flag, 0) + dfs(cur.right, flag, 0);
            int res2 = 2 + dfs(cur.left, flag ^ 1, 0) + dfs(cur.right, flag ^ 1, 0);
            int res3 = 2 + dfs(cur.left, flag, 1) + dfs(cur.right, flag, 1);
            int res4 = 2 + dfs(cur.left, flag ^ 1, 1) + dfs(cur.right, flag ^ 1, 1);
            int res = Math.min(Math.min(res1, res2), Math.min(res3, res4));
            memoMap.put(key, res);
            return res;
        }

//        开关 1：切换当前节点的灯的状态；
//        开关 2：切换 以当前节点为根 的子树中，所有节点上的灯的状态，；
//        开关 3：切换 当前节点及其左右子节点（若存在的话） 上的灯的状态；

        int res1 = 1 + dfs(cur.left, flag, 0) + dfs(cur.right, flag, 0);
        int res2 = 1 + dfs(cur.left, flag ^ 1, 0) + dfs(cur.right, flag ^ 1, 0);
        int res3 = 1 + dfs(cur.left, flag, 1) + dfs(cur.right, flag, 1);
        int res = Math.min(Math.min(res1, res2), res3);
        memoMap.put(key, res);
        return res;
    }

    public int closeLampInTree(TreeNode root) {
        memoMap = new HashMap<>();
        return dfs(root, 0, 0);
    }

}
