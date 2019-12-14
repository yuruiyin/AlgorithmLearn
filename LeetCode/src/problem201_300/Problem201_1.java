package problem201_300;

public class Problem201_1 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }

        int ans = m;
        for (int i = m + 1; ans != 0 && i <= n && i >= 0; i++) {
            ans &= i;
        }
        return ans;
    }

}
