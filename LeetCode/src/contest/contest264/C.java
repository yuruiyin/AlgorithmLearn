package contest.contest264;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/24
 */
public class C {

    private int len;
    private int[] parents;
    private long ansMax = 1;
    private List<Integer>[] adj;
    private int ansCount = 0;

    private void createTree() {
        adj = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            if (parents[i] == -1) {
                continue;
            }

            if (adj[parents[i]] == null) {
                adj[parents[i]] = new ArrayList<>();
            }
            adj[parents[i]].add(i);
        }
    }

    private int dfs(int cur) {
        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            // 叶子
            ansMax = Math.max(ansMax, len - 1);
            return 1;
        }

        int count = 1;
        long value = 1;
        for (int next: nextList) {
            int childCount = dfs(next);
            value *= childCount;
            count += childCount;
        }

        value *= Math.max(1, len - count);
        ansMax = Math.max(value, ansMax);
        return count;
    }

    private int dfs1(int cur) {
        List<Integer> nextList = adj[cur];
        if (nextList == null) {
            // 叶子
            if (len - 1 == ansMax) {
                ansCount++;
            }
            return 1;
        }

        int count = 1;
        long value = 1;
        for (int next: nextList) {
            int childCount = dfs1(next);
            value *= childCount;
            count += childCount;
        }

        value *= Math.max(1, len - count);
        if (value == ansMax) {
            ansCount++;
        }
        return count;
    }

    public int countHighestScoreNodes(int[] parents) {
        this.parents = parents;
        this.len = parents.length;
        createTree();
        dfs(0);
        dfs1(0);
        return ansCount;
    }

}
