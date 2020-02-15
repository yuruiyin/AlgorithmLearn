package problem1001_1100;

public class Problem1009_1 {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int tmp = n;
        int res = 1;
        while (tmp > 0) {
            tmp >>= 1;
            res <<= 1;
        }

        return n ^ (res - 1);
    }

}
