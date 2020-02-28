package lcci;

public class Lcci0507 {

    public int exchangeBits(int num) {
        int ans = 0;
        for (int i = 0; i < 32; i+=2) {
            if (num == 0) {
                break;
            }
            int bit1 = num & 1;
            num >>>= 1;
            int bit2 = num & 1;
            ans += (1 << i) * bit2;
            ans += (1 << (i + 1)) * bit1;
            num >>>= 1;
        }

        return ans;
    }

}
