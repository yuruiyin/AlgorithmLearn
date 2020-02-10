package problem1001_1100;

public class Problem1006 {

    public int clumsy(int n) {
        int ans = 0;
        int pre = n;
        for (int i = n; i >= 2; i--) {
            int index = (n - i) % 4;
            if (index == 0) {
                // *
                pre *= (i - 1);
            } else if (index == 1) {
                // /
                pre /= (i - 1);
            } else if (index == 2) {
                // +
                pre += (i - 1);
            } else {
                // -
                ans += pre;
                pre = 1-i;
            }
        }

        ans += pre;

        return ans;
    }

}
