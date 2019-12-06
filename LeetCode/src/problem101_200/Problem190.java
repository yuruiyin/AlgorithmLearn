package problem101_200;

public class Problem190 {

    private void createReversedBinaryArr(int n, char[] arr) {
        for (int i = 0; i < 32; i++) {
            arr[i] = (char) (n & 1);
            n >>>= 1;
        }
    }

    public int reverseBits(int n) {
        char[] reversedArr = new char[32];
        createReversedBinaryArr(n, reversedArr);
        int len = reversedArr.length;
        int ans = 0;
        char signChar = reversedArr[0];
        int sign = signChar == 1 ? -1 : 1;

        if (sign == -1) {
            // 负数
            // 取反
            for (int i = 1; i < len; i++) {
                reversedArr[i] ^= 1;
            }
            // 加1
            int carry = 1;
            for (int i = len - 1; i >= 1; i--) {
                char oldNum = reversedArr[i];
                reversedArr[i] = (char) ((reversedArr[i] + carry) % 2);
                carry = (oldNum + carry) / 2;
                if (carry == 0) {
                    break;
                }
            }
        }

        for (int i = 1; i < len; i++) {
            ans *= 2;
            ans += reversedArr[i];
        }

        if (sign == -1 && ans == 0) {
            return -Integer.MIN_VALUE;
        }

        return sign * ans;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem190().reverseBits(43261596));
        System.out.println(new Problem190().reverseBits(-3));
    }

}
