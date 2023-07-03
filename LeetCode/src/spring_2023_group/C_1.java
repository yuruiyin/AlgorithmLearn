package spring_2023_group;

import java.util.*;

public class C_1 {

    private char[] arr;
    private List<int[]>[] posListArr;

    class Node {
        int cost;
        int idx;
        int r;
        int c;
        Node(int cost, int idx, int r, int c) {
            this.cost = cost;
            this.idx = idx;
            this.r = r;
            this.c = c;
        }
    }

    public int extractMantra(String[] matrix, String mantra) {
        posListArr = new ArrayList[26];
        Arrays.setAll(posListArr, value -> new ArrayList<>());
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = matrix[i].toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                posListArr[c - 'a'].add(new int[]{i, j});
            }
        }

        arr = mantra.toCharArray();
        for (char c : arr) {
            if (posListArr[c - 'a'].isEmpty()) {
                return -1;
            }
        }

        // 堆优化的dijkstra
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        List<int[]> posList = posListArr[arr[0] - 'a'];
//        int[][][] dis = new int[arr.length][m][n];
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < m; j++) {
//                Arrays.fill(dis[i][j], Integer.MAX_VALUE);
//            }
//        }

        int[] minDis = new int[arr.length];
        Arrays.fill(minDis, Integer.MAX_VALUE);

        for (int[] pos: posList) {
            int cost = Math.abs(pos[0]) + Math.abs(pos[1]);
            heap.add(new Node(cost, 0, pos[0], pos[1]));
//            dis[0][pos[0]][pos[1]] = Math.min(dis[0][pos[0]][pos[1]], cost);
            minDis[0] = Math.min(minDis[0], cost);
        }

        while (!heap.isEmpty()) {
            Node top = heap.poll();
            int nextIdx = top.idx + 1;
            if (nextIdx == arr.length) {
//                dis[top.idx][top.r][top.c] = Math.min(dis[top.idx][top.r][top.c], top.cost);
                minDis[top.idx] = Math.min(minDis[top.idx], top.cost);
                continue;
            }
            char nextChar = arr[nextIdx];
            List<int[]> nextPosList = posListArr[nextChar - 'a'];
//            List<Node> tmpNodeList = new ArrayList<>();
            int lastMinCost = Integer.MAX_VALUE;
            for (int i = nextIdx + 1; i < arr.length; i++) {
                lastMinCost = Math.min(lastMinCost, minDis[i]);
            }
            for (int[] nextPos : nextPosList) {
                int nextR = nextPos[0];
                int nextC = nextPos[1];
                int cost = Math.abs(nextR - top.r) + Math.abs(nextC - top.c) + top.cost;
//                tmpNodeList.add(new Node(cost, nextIdx, nextR, nextC));
//                if (cost < dis[nextIdx][nextR][nextC] && cost < lastMinCost) {
                if (cost < lastMinCost) {
                    heap.add(new Node(cost, nextIdx, nextR, nextC));
                    minDis[nextIdx] = Math.min(minDis[nextIdx], cost);
//                    dis[nextIdx][nextR][nextC] = cost;
//                    minDis[nextIdx] = Math.min(minDis[nextIdx], cost);
                }
            }
        }

        return minDis[arr.length - 1] + arr.length;

//        int ansMin = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                ansMin = Math.min(dis[arr.length - 1][i][j], ansMin);
//            }
//        }
//
//        return ansMin + arr.length;
    }

}
