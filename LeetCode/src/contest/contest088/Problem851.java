package contest.contest088;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem851 {

    private int bfs(List<Integer>[] adj, int[] quiet, int cur) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(cur);

        int minQuiet = Integer.MAX_VALUE;
        int minQuietPerson = cur;
        boolean[] visited = new boolean[quiet.length];
        visited[cur] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int person = queue.poll();
                if (quiet[person] < minQuiet) {
                    minQuiet = quiet[person];
                    minQuietPerson = person;
                }

                for (Integer nextPerson : adj[person]) {
                    if (visited[nextPerson]) {
                        continue;
                    }

                    visited[nextPerson] = true;
                    queue.offer(nextPerson);
                }
            }
        }

        return minQuietPerson;
    }

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        List<Integer>[] adj = new ArrayList[len];

        for (int i = 0; i < len; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] rich: richer) {
            int from = rich[1];
            int to = rich[0];
            adj[from].add(to);
        }

        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            ansArr[i] = bfs(adj, quiet, i);
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[][] richer = new int[][]{
                {1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}
        };

        int[] quiet = new int[]{3,2,5,4,6,1,7,0};
        int[] ansArr = new Problem851().loudAndRich(richer, quiet);
        PrintUtil.printIntArray(ansArr);
    }

}
