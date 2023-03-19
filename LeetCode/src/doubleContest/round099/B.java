package doubleContest.round099;

public class B {

    public long coloredCells(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 5;
        }

        int cur = 1;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += cur;
            cur += 2;
        }
        sum *= 2;
        sum += cur;
        return sum;
    }

}
