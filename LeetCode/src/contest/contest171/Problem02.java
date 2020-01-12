package contest.contest171;

public class Problem02 {

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int aBit = a & 1;
            int bBit = b & 1;
            int cBit = c & 1;
            if ((aBit | bBit) != cBit) {
                if (cBit == 0) {
                    ans += aBit + bBit;
                } else {
                    ans += 1;
                }
            }

            a >>>= 1;
            b >>>= 1;
            c >>>= 1;
        }

        return ans;
    }

}
