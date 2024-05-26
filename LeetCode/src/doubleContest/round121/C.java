package doubleContest.round121;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class C {

    private int[] dp;

    private final int MAX = 110001;

    private int rec(int x, int y) {
        if (x == y) {
            return 0;
        }

        if (x < y) {
            return y - x;
        }

        if (x >= MAX) {
            return 10000;
        }

        if (dp[x] != -1) {
            return dp[x];
        }

        int res = 10000;
        if (x % 11 == 0) {
            res = Math.min(res, rec(x / 11, y) + 1);
        }
        if (x % 5 == 0) {
            res = Math.min(res, rec(x / 5, y) + 1);
        }
        res = Math.min(res, rec(x - 1, y) + 1);
        res = Math.min(res, rec(x + 1, y) + 1);
        return dp[x] = res;
    }

    public int minimumOperationsToMakeEqual(int x, int y) {
        // bfs
        int[] costArr = new int[110001];
        Arrays.fill(costArr, 10000);
        int ans = 10000;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(x);
        costArr[x] = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int top = queue.pollFirst();
                if (top == y) {
                    ans = Math.min(ans, level);
                } else if (top < y) {
                    ans = Math.min(ans, level + y - top);
                } else {
                    int curCost = costArr[top];
                    if (top % 11 == 0) {
                        int nextX = top / 11;
                        if (curCost + 1 < costArr[nextX]) {
                            costArr[nextX] = curCost + 1;
                            queue.add(nextX);
                        }
                    }
                    if (top % 5 == 0) {
                        int nextX = top / 5;
                        if (curCost+ 1 < costArr[nextX]) {
                            costArr[nextX] = curCost + 1;
                            queue.add(nextX);
                        }
                    }

                    int nextX = top - 1;
                    if (curCost + 1 < costArr[nextX]) {
                        costArr[nextX] = curCost + 1;
                        queue.add(nextX);
                    }

                    nextX = top + 1;
                    if (curCost + 1 < costArr[nextX]) {
                        costArr[nextX] = curCost + 1;
                        queue.add(nextX);
                    }
                }
            }
            level++;
        }

        return ans;

    }

}
