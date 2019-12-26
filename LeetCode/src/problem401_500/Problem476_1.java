package problem401_500;

public class Problem476_1 {

    public int findComplement(int num) {
        int ans = 0;
        int tmp = 1;

        // 不断右移
        while (num != 0) {
            if ((num & 1) == 0) {
                ans |= tmp;
            }

            tmp <<= 1;
            num >>>= 1;
        }

        return ans;
    }

}
