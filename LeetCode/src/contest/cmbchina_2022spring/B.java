package contest.cmbchina_2022spring;

import java.util.List;

public class B {

    public int numFlowers(int[][] roads) {
        int n = roads.length + 1;
        int[] countArr = new int[n];
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            countArr[u]++;
            countArr[v]++;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, countArr[i]);
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
