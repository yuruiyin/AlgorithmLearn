package problem101_200;

public class Problem191_1 {

    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (n == 0) {
                return ans;
            }
            ans += (n & 1);
            n >>>= 1;
        }

        return ans;
    }

}
