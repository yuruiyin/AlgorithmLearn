package lcci;

public class Lcci0805 {

    public int multiply(int A, int B) {
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        int ans = 0;

        for (int i = 0; i < min; i++) {
            ans += max;
        }

        return ans;
    }

}
