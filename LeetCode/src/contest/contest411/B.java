package contest.contest411;

public class B {

    private int[] arr1;
    private int[] arr2;

    private int len;
    private Long[][] memo;

    private long rec(int i, int j) {
        if (j == len) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        long chooseRes = 0;
        if (i == 0) {
            chooseRes = arr1[j] + rec(i, j + 1);
        } else {
            chooseRes = arr2[j] + rec(i, j + 1);
        }
        long nonChooseRes = rec(i ^ 1, j + 1);
        return memo[i][j] = Math.max(chooseRes, nonChooseRes);
    }

    public long maxEnergyBoost(int[] arr1, int[] arr2) {
        this.len = arr1.length;
        this.arr1 = arr1;
        this.arr2 = arr2;
        memo = new Long[2][len];
        return Math.max(rec(0,  1) + arr1[0], rec(1, 1) + arr2[0]);
    }

}
