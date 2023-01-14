package contest.contest323;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D_1 {

    class Query {
        int idx;
        int value;
        Query(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int k = queries.length;
        int[] ansArr = new int[k];

        // bfs
        Query[] queryArr = new Query[k];
        for (int i = 0; i < k; i++) {
            queryArr[i] = new Query(i, queries[i]);
        }

        Arrays.sort(queryArr, new Comparator<Query>() {
            @Override
            public int compare(Query o1, Query o2) {
                return o1.value - o2.value;
            }
        });

        if (grid[0][0] >= queryArr[k - 1].value) {
            // 左上角的数太大了
            return new int[k];
        }

        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
            }
        });
        queue.add(new int[]{0, 0});
        boolean[] visited = new boolean[100001];
        visited[0] = true;

        int lastValue = 0;

        for (int qIdx = 0; qIdx < queryArr.length; qIdx++) {
            int curMax = queryArr[qIdx].value;
            if (grid[0][0] >= curMax) {
                ansArr[queryArr[qIdx].idx] = 0;
                continue;
            }
            int curValue = 0;
            while (!queue.isEmpty()) {
                int[] minTop = queue.peek();
                if (grid[minTop[0]][minTop[1]] >= curMax) {
                    break;
                }
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] top = queue.peek();
                    int r = top[0];
                    int c = top[1];
                    if (grid[r][c] >= curMax) {
                        break;
                    }
                    queue.poll();
                    curValue++;
                    for (int j = 0; j < 4; j++) {
                        int nextR = r + dx[j];
                        int nextC = c + dy[j];
                        int idx = nextR * n + nextC;
                        if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || visited[idx]) {
                            continue;
                        }

                        visited[idx] = true;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }

            lastValue += curValue;
            ansArr[queryArr[qIdx].idx] = lastValue;
        }

        return ansArr;

     }

    public static void main(String[] args) {
        System.out.println(new D_1().maxPoints(new int[][]{
                {1,2,3},{2,5,7},{3,5,1}
        }, new int[]{5,6,2}));
    }

}
