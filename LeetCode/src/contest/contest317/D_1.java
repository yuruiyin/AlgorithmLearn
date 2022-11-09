package contest.contest317;

import common.TreeNode;

import java.util.*;

public class D_1 {

    static class Node {
        int height;
        int bottomMaxHeight;
        Node(int height, int bottomMaxHeight) {
            this.height = height;
            this.bottomMaxHeight = bottomMaxHeight;
        }
    }

    private static Node[] map;

    private List<Integer>[] sameLevelListArr;

    private int maxLevel = 0;

    private static final Comparator<Integer> comparator = new Comparator<>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return map[o2].bottomMaxHeight - map[o1].bottomMaxHeight;
        }
    };

    private int dfs(TreeNode cur, int level) {
        if (cur == null) {
            return 0;
        }

        if (sameLevelListArr[level] == null) {
            sameLevelListArr[level] = new ArrayList<>();
        }
        sameLevelListArr[level].add(cur.val);
        if (cur.left == null && cur.right == null) {
            if (level > maxLevel) {
                maxLevel = level;
            }
            map[cur.val] = new Node(level, 0);
            return 0;
        }

        int bottomMaxHeight = Math.max(dfs(cur.left, level + 1), dfs(cur.right, level + 1)) + 1;
        map[cur.val] = new Node(level, bottomMaxHeight);
        return bottomMaxHeight;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        map = new Node[100001];
        sameLevelListArr = new ArrayList[100001];
        dfs(root, 0);
        int len = queries.length;
        int[] ansArr = new int[len];
        for (int i = 0; i <= maxLevel; i++) {
            if (sameLevelListArr[i] == null || sameLevelListArr[i].size() <= 2) {
                continue;
            }
            sameLevelListArr[i].sort(comparator);
        }
        for (int i = 0; i < len; i++) {
            int q = queries[i];
            int level = map[q].height;
            List<Integer> sameLevelList = sameLevelListArr[level];
            int ansMax = level - 1;
            if (sameLevelList.size() == 1) {
                ansArr[i] = ansMax;
                continue;
            }
            int nextMaxVal;
            if (sameLevelList.get(0) == q) {
                nextMaxVal = sameLevelList.get(1);
            } else {
                nextMaxVal = sameLevelList.get(0);
            }
            int tmpRes = map[nextMaxVal].bottomMaxHeight + level;
            if (tmpRes > ansMax) {
                ansMax = tmpRes;
            }
            ansArr[i] = ansMax;
        }
        return ansArr;
    }

}
