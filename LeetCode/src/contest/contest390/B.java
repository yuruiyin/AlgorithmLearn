package contest.contest390;

public class B {

    public int minOperations(int k) {
        if (k == 1) {
            return 0;
        }

        if (k == 2) {
            return 1;
        }

        int ansMin = k - 1;
        for (int i = 1; i <= k - 1; i++) {
            int num = i + 1;
            ansMin = Math.min(ansMin, i + (k / num + (k % num == 0 ? 0 : 1)) - 1);
        }
        return ansMin;
    }

}
