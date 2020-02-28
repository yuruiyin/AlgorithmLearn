package lcci;

public class Lcci0501 {

    public int insertBits(int n, int m, int i, int j) {
        int ans = 0;

        int k;
        for (k = 0; k < i; k++) {
            ans += (1 << k) * (n & 1);
            n >>>= 1;
        }

        for (k = i; k <= j; k++) {
            ans += (1 << k) * (m & 1);
            m >>>= 1;
            n >>>= 1;
        }

        while (n > 0) {
            ans += (1 << k) * (n & 1);
            k++;
            n >>>= 1;
        }

        return ans;
    }

}
