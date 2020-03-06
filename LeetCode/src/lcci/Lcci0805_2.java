package lcci;

public class Lcci0805_2 {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);

        if (min == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; min != 0; i++) {
            if ((min & 1) == 1) {
                ans += max << i;
            }
            min >>= 1;
        }

        return ans;
    }


}
