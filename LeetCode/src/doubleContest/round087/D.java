package doubleContest.round087;

public class D {

    public long minimumMoney(int[][] transactions) {
        // transactions = [[2,1],[5,0],[4,2]]
        long ansSum = 0;
        int len = transactions.length;
        int maxValue = 0;
        for (int i = 0; i < len; i++) {
            if (transactions[i][0] > transactions[i][1]) {
                ansSum += transactions[i][0] - transactions[i][1];
                maxValue = Math.max(maxValue, transactions[i][1]);
            }
        }

        long ansMax = ansSum + maxValue;
        for (int i = 0; i < len; i++) {
            if (transactions[i][0] <= transactions[i][1]) {
                ansMax = Math.max(ansMax, ansSum + transactions[i][0]);
            }
        }
        return ansMax;
    }

}
