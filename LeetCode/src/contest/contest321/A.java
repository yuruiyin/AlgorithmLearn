package contest.contest321;

public class A {

    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            pre += i;
            if (pre == sum - pre + i) {
                return i;
            }
        }
        return -1;
    }

}
