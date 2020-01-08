package problem901_1000;

public class Problem926 {

    public int minFlipsMonoIncr(String str) {
        char[] arr1 = str.toCharArray();
        int len = arr1.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = arr1[i] - '0';
        }
        int[] rightZeroCountArr = new int[len];
        int[] leftOneCountArr = new int[len];

        leftOneCountArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            leftOneCountArr[i] = leftOneCountArr[i-1] + arr[i];
        }

        rightZeroCountArr[len - 1] = arr[len - 1] ^ 1;
        for (int i = len - 2; i >= 0; i--) {
            rightZeroCountArr[i] = rightZeroCountArr[i+1] + (arr[i] ^ 1);
        }

        // 全0
        int oneCount = 0;
        int zeroCount = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) {
                oneCount++;
            } else {
                zeroCount++;
            }
        }

        // 左0，右1
        int min = Math.min(zeroCount, oneCount);
        for (int i = len - 2; i  >= 1; i--) {
            if (leftOneCountArr[i-1] == 0) {
                min = Math.min(min, rightZeroCountArr[i+1]);
                break;
            }

            min = Math.min(min, leftOneCountArr[i-1] + rightZeroCountArr[i+1]);
        }

        return min;
    }

}

//  如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
//
//        我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
//
//        返回使 S 单调递增的最小翻转次数。
//
//
//
//        示例 1：
//
//        输入："00110"
//        输出：1
//        解释：我们翻转最后一位得到 00111.
//        示例 2：
//
//        输入："010110"
//        输出：2
//        解释：我们翻转得到 011111，或者是 000111。
//        示例 3：
//
//        输入："00011000"
//        输出：2
//        解释：我们翻转得到 00000000。
//
//
//        提示：
//
//        1 <= S.length <= 20000
//        S 中只包含字符 '0' 和 '1'
