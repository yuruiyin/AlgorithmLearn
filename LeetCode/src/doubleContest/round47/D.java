package doubleContest.round47;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/7
 */
public class D {

    class Data {
        int idx;
        int degree;

        Data(int idx, int degree) {
            this.idx = idx;
            this.degree = degree;
        }
    }

    private int findFirstBigger(List<Data> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target < list.get(mid).degree) {
                if (mid == 0 || target >= list.get(mid - 1).degree) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        Set<Integer>[] adj = new HashSet[n + 1];
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            degree[u]++;
            degree[v]++;
            if (adj[u] == null) {
                adj[u] = new HashSet<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new HashSet<>();
            }
            adj[v].add(u);

            int min = Math.min(u, v);
            int max = Math.max(u, v);
            int key = min * (n + 1) + max;
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        List<Data> datas = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            datas.add(new Data(i, degree[i]));
        }

        Collections.sort(datas, Comparator.comparingInt(o -> o.degree));

        int[] ansArr = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int query = queries[k];
            int count = 0;
            int sameCount = 0;
            for (int i = 0; i < n; i++) {
                Data data = datas.get(i);
                if (data == null) {
                    continue;
                }
                int curDegree = data.degree;
                int curIdx = data.idx;
                int targetDegree = query - curDegree;
                int targetIdx = findFirstBigger(datas, targetDegree);
                if (targetIdx == -1) {
                    continue;
                }

                count += n - targetIdx;

                if (degree[curIdx] > targetDegree) {
                    sameCount++;
                }

                Set<Integer> nextList = adj[curIdx];
                if (nextList == null) {
                    continue;
                }
                for (int next : nextList) {
                    int minIdx = Math.min(curIdx, next);
                    int maxIdx = Math.max(curIdx, next);
                    int key = minIdx * (n + 1) + maxIdx;
                    if (degree[next] > targetDegree && curDegree + degree[next] - countMap.getOrDefault(key, 0) <= query) {
                        count--;
                    }
                }

            }
            ansArr[k] = (count - sameCount) / 2;
        }

        return ansArr;
    }

    public static void main(String[] args) {
        // 2
        //[[1,2],[1,2]]
        //[1,2]
        int[] ansArr = new D().countPairs(
                2, new int[][]{{1, 2}, {1, 2}}, new int[]{1,2}
        );

//        int[] ansArr = new D().countPairs(
//                4, new int[][]{{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}}, new int[]{2, 3}
//        );
    }

}
