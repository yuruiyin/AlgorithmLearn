package lcci;

public class Lcci0506 {

    public int convertInteger(int a, int b) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (a == b) {
                break;
            }

            ans += (a & 1) ^ (b & 1);
            a >>>= 1;
            b >>>= 1;
        }

        return ans;
    }

}
