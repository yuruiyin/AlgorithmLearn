package fall_2021_group;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/25
 */
public class C {

    class Data {
        // s = a + b * x
        long a;
        long b;
        Data(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public int[] volunteerDeployment(int[] finalCnt, long totalNum, int[][] edges, int[][] plans) {
        int n = finalCnt.length + 1;
        Data[] arr = new Data[n];
        arr[0] = new Data(0, 1);
        for (int i = 1; i < n; i++) {
            arr[i] = new Data(finalCnt[i - 1], 0);
        }

        List<Integer>[] adj = new ArrayList[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj[u] == null) {
                adj[u] = new ArrayList<>();
            }
            adj[u].add(v);
            if (adj[v] == null) {
                adj[v] = new ArrayList<>();
            }
            adj[v].add(u);
        }

        for (int i = plans.length - 1; i >= 0; i--) {
            int[] plan = plans[i];
            int type = plan[0];
            int idx = plan[1];
            if (type == 1) {
                arr[idx].a <<= 1;
                arr[idx].b <<= 1;
            } else {
                List<Integer> neighborList = adj[idx];
                if (neighborList != null) {
                    Data curData = arr[idx];
                    for (int next : neighborList) {
                        Data nextData = arr[next];
                        if (type == 2) {
                            nextData.a -= curData.a;
                            nextData.b -= curData.b;
                        } else {
                            nextData.a += curData.a;
                            nextData.b += curData.b;
                        }
                    }
                }
            }
        }

        long aSum = 0;
        long bSum = 0;
        for (int i = 0; i < n; i++) {
            aSum += arr[i].a;
            bSum += arr[i].b;
        }

        int[] ansArr = new int[n];
        int x = (int) ((totalNum - aSum) / bSum);
        for (int i = 0; i < n; i++) {
            ansArr[i] = (int) (arr[i].a + arr[i].b * x);
        }
        return ansArr;
    }

}
