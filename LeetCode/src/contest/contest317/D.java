package contest.contest317;

import common.TreeNode;

import java.util.*;

public class D {

    static class Node {
        int height;
        int bottomMaxHeight;
        Node(int height, int bottomMaxHeight) {
            this.height = height;
            this.bottomMaxHeight = bottomMaxHeight;
        }
    }

    private Node[] map;

    private PriorityQueue<Integer>[] sameLevelListArr;

    private int dfs(TreeNode cur, int level) {
        if (cur == null) {
            return 0;
        }

        if (cur.left == null && cur.right == null) {
            map[cur.val] = new Node(level, 0);
            return 0;
        }

        map[cur.val] = new Node(level, Math.max(dfs(cur.left, level + 1), dfs(cur.right, level + 1)) + 1);
        return map[cur.val].bottomMaxHeight;
    }

    private void dfs1(TreeNode cur, int level) {
        if (cur == null) {
            return;
        }
        sameLevelListArr[level].add(cur.val);
        dfs1(cur.left, level + 1);
        dfs1(cur.right, level + 1);
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        map = new Node[100001];
        sameLevelListArr = new PriorityQueue[100001];
        Arrays.setAll(sameLevelListArr, value -> new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map[o2].bottomMaxHeight - map[o1].bottomMaxHeight;
            }
        }));
        dfs(root, 0);
        dfs1(root, 0);
        int len = queries.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int q = queries[i];
            int level = map[q].height;
            PriorityQueue<Integer> sameLevelList = sameLevelListArr[level];
            int ansMax = level - 1;
            if (sameLevelList.size() >= 2) {
                int top = sameLevelList.peek();
                if (top == q) {
                    sameLevelList.poll();
                    top = sameLevelList.peek();
                    sameLevelList.add(q);
                }
                int value = level + map[top].bottomMaxHeight;
                if (value > ansMax) {
                    ansMax = value;
                }
            }
            ansArr[i] = ansMax;
        }
        return ansArr;
    }

}
