package contest.contest129;

public class Problem1015 {

    // 大数mod
    private boolean modEqualToZero(String numStr, int k) {
        StringBuilder sb = new StringBuilder(numStr);
        int len = sb.length();
        int kLen = String.valueOf(k).length();
        int i;
        for (i = 0; i + kLen <= len; ) {
            String str = sb.substring(i, i + kLen);
            if (Integer.parseInt(str) == k) {
                i = i + kLen;
            } else {
                if (i + kLen >= len) {
                    return false;
                }

                String str2 = sb.substring(i, i + kLen + 1);
                int num2 = Integer.parseInt(str2);
                int mod = num2 % k;
                int nextI;
                for (nextI = i + kLen; mod > 0 ;nextI--) {
                    sb.setCharAt(nextI, (char) ((mod % 10) + '0'));
                    mod /= 10;
                }

                i = nextI + 1;
            }
        }

        return i == len;
    }

    public int smallestRepunitDivByK(int k) {
        int lowBit = k % 10;
        if (!(lowBit == 1 || lowBit == 3 || lowBit == 7 || lowBit == 9)) {
            return -1;
        }

        int sum = 0;
        for (int i = 1; ; i++) {
            sum = (sum * 10 + 1) % k;
            if (sum == 0) {
                return i;
            }
        }
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem02().smallestRepunitDivByK(19927));
        System.out.println(new Problem1015().smallestRepunitDivByK(11));
        System.out.println(new Problem1015().smallestRepunitDivByK(1));
        System.out.println(new Problem1015().smallestRepunitDivByK(2));
        System.out.println(new Problem1015().smallestRepunitDivByK(3));

    }

}

//    给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
//
//        返回 N 的长度。如果不存在这样的 N，就返回 -1。
//
//        示例 1：
//
//        输入：1
//        输出：1
//        解释：最小的答案是 N = 1，其长度为 1。
//        示例 2：
//
//        输入：2
//        输出：-1
//        解释：不存在可被 2 整除的正整数 N 。
//        示例 3：
//
//        输入：3
//        输出：3
//        解释：最小的答案是 N = 111，其长度为 3。
//
//
//        提示：
//
//        1 <= K <= 10^5

