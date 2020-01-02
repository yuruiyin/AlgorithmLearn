package problem801_900;

import java.util.Arrays;
import java.util.Comparator;

public class Problem879 {

    private static final int MOD = (int) (1e9 + 7);

    private int len;
    private Data[] datas;
    private int[][][] memo;

    class Data {
        int profit;
        int personCount;
        Data(int profit, int personCount) {
            this.profit = profit;
            this.personCount = personCount;
        }
    }

    private int backTrack(int leftPCount, int leftProfit, int from) {
        if (from == len) {
            if (leftProfit > 0) {
                return 0;
            } else {
                return 1;
            }
        }

        if (memo[leftPCount][leftProfit][from] != -1) {
            return memo[leftPCount][leftProfit][from];
        }

        Data data = datas[from];
        int chooseRes = 0;
        if (leftPCount - data.personCount >= 0) {
            chooseRes = backTrack(leftPCount - data.personCount, Math.max(leftProfit - data.profit, 0), from + 1);
        }
        int nonChooseRes = backTrack(leftPCount, leftProfit, from + 1);
        memo[leftPCount][leftProfit][from] = (chooseRes + nonChooseRes) % MOD;
        return memo[leftPCount][leftProfit][from];
    }

    public int profitableSchemes(int personCount, int p, int[] group, int[] profit) {
        this.len = profit.length;
        datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(profit[i], group[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.profit - o2.profit;
            }
        });

        memo = new int[personCount + 1][p + 1][len];
        for (int i = 0; i <= personCount; i++) {
            for (int j = 0; j <= p; j++) {
                for (int k = 0; k < len; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        return backTrack(personCount, p, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem879().profitableSchemes(5, 3, new int[]{2, 2}, new int[]{2, 3}));
        System.out.println(new Problem879().profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8}));
        System.out.println(new Problem879().profitableSchemes(1, 1, new int[]{2,2,2,2,2}, new int[]{1,2,1,1,0}));
    }

}
