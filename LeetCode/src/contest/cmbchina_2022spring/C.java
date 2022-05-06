package contest.cmbchina_2022spring;

import java.util.*;

public class C {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    public int[] lightSticks(int height, int width, int[] indices) {
        int nodeRowCount = height + 1;
        int nodeColCount = width + 1;
        List<Integer>[] adj = new ArrayList[nodeRowCount * nodeColCount];
        Arrays.setAll(adj, value -> new ArrayList<>());
        boolean[][] remove = new boolean[2600][2600];
        for (int num : indices) {
            // 被移除的木棍编号，木棍是w, w + 1, w, w + 1 ...
            // 计算num对应的两个端点
            int count = -1;
            int r = 0;
            while (count < num) {
                if (r % 2 == 0) {
                    if (count + width >= num) {
                        // 当前是横的火柴
                        int diff = num - count;
                        int u = (r / 2) * nodeColCount + diff - 1;
                        int v = u + 1;
                        remove[u][v] = true;
                        remove[v][u] = true;
                        break;
                    }
                    count += width;
                } else {
                    if (count + width + 1 >= num) {
                        // 当前是竖火柴
                        int diff = num - count;
                        int u = (r / 2) * nodeColCount + diff - 1;
                        int v = u + nodeColCount;
                        remove[u][v] = true;
                        remove[v][u] = true;
                        break;
                    }
                    count += width + 1;
                }
                r++;
            }
        }
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                int curNode = i * nodeColCount + j;
                for (int ii = 0; ii < 4; ii++) {
                    int nextRow = i + dx[ii];
                    int nextCol = j + dy[ii];
                    int nextNode = nextRow * nodeColCount + nextCol;
                    if (nextRow < 0 || nextRow >= nodeRowCount || nextCol < 0 || nextCol >= nodeColCount || remove[curNode][nextNode]) {
                        continue;
                    }

                    adj[curNode].add(nextNode);
                }
            }
        }

        // 剩下的火柴根数
        int totalCount = nodeRowCount * width + (width + 1) * (nodeRowCount - 1);
        int leftCount = totalCount - indices.length;

        // bfs
        List<int[]> countList = new ArrayList<>();
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                int curNode = i * nodeColCount + j;
                int count = bfs(adj, curNode, leftCount);
                if (count == -1) {
                    continue;
                }
                countList.add(new int[]{count, curNode});
            }
        }

        Collections.sort(countList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        if (countList.isEmpty()) {
            return new int[0];
        }

        int ansMin = countList.get(0)[0];
        List<Integer> ansList = new ArrayList<>();
        for (int[] node : countList) {
            if (node[0] != ansMin) {
                break;
            }
            ansList.add(node[1]);
        }
        return ansList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(List<Integer>[] adj, int node, int leftCount) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(node);
        boolean[] visited = new boolean[2600];
        Set<Integer> edgeVisited = new HashSet<>();
        visited[node] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.pollFirst();
                List<Integer> nextList = adj[cur];
                for (int next: nextList) {
                    if (!edgeVisited.contains(cur * 2600 + next) && !edgeVisited.contains(next * 2600 + cur)) {
                        edgeVisited.add(cur * 2600 + next);
                    }
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }
            level++;
        }
        return edgeVisited.size() == leftCount ? level - 1 : -1;
    }

    public static void main(String[] args) {
//        int[] ansArr = new C().lightSticks(1, 2, new int[]{3});
        int[] ansArr = new C().lightSticks(2, 2, new int[]{2,5,6,7,8,10,11});
        for (int num : ansArr) {
            System.out.print(num + " ");
        }
        System.out.println();
//        System.out.println("hello world");
    }

}
