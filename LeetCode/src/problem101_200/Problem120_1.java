package problem101_200;

import java.util.List;

public class Problem120_1 {

    /**
     * DP, 自底向上
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 0) {
            return 0;
        }

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> curRowList = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                int min = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + curRowList.get(j);
                curRowList.set(j, min);
            }
        }

        return triangle.get(0).get(0);
    }

}
