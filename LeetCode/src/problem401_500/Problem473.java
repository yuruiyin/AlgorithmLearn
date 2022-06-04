package problem401_500;

import java.util.Arrays;

public class Problem473 {

    private int len;
    private int[] matchsticks;

    /**
     * 是否存在有三边都等于边长
     */
    private boolean hasThreeEqualsEdgeLen(int[] edges, int edgeLen) {
        int[] newEdges = Arrays.copyOf(edges, edges.length);
        Arrays.sort(newEdges);
        return newEdges[1] == edgeLen;
    }

    private boolean dfs(int index, int[] edges, int edgeLen) {
        // 有三边都等于边长之后
        if (hasThreeEqualsEdgeLen(edges, edgeLen)) {
            return true;
        }

        if (index == len - 1) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (edges[i] + matchsticks[index] > edgeLen || (i > 0 && edges[i] == edges[i - 1])) {
                continue;
            }

            edges[i] += matchsticks[index];
            if (dfs(index + 1, edges, edgeLen)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int edgeLen = sum / 4;
        this.len = matchsticks.length;
        if (matchsticks[len - 1] > edgeLen) {
            return false;
        }
        this.matchsticks = matchsticks;
        int[] edges = new int[4];
        Arrays.sort(matchsticks);
        for (int l = 0, r = len - 1; l < r; l++, r--) {
            // 逆序
            swap(matchsticks, l, r);
        }
        return dfs(0, edges, edgeLen);
    }

    public static void main(String[] args) {
//        System.out.println(new Problem473().makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
        // [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
        System.out.println(new Problem473().makesquare(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15}));
    }

}
