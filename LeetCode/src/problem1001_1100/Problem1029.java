package problem1001_1100;

import java.util.HashMap;
import java.util.Map;

public class Problem1029 {

    private Map<String, Integer> memo;

    private int backTrack(int[][] costs, int from, int needCountA, int needCountB) {
        if (needCountA == 0 && needCountB == 0) {
            return 0;
        }

        String key = from + "," + needCountA + "," + needCountB;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int[] curCost = costs[from];

        int chooseACost = Integer.MAX_VALUE;
        if (needCountA > 0) {
            chooseACost = backTrack(costs, from+1, needCountA - 1, needCountB) + curCost[0];
        }

        int chooseBCost = Integer.MAX_VALUE;
        if (needCountB > 0) {
            chooseBCost = backTrack(costs, from+1, needCountA, needCountB - 1) + curCost[1];
        }

        int res = Math.min(chooseACost, chooseBCost);
        memo.put(key, res);

        return res;
    }

    public int twoCitySchedCost(int[][] costs) {
        int len = costs.length;
        memo = new HashMap<>();

        return backTrack(costs, 0, len / 2, len / 2);
    }
    
    public static void main(String[] args) {

    }
    
}
