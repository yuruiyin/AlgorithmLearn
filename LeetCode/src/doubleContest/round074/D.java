package doubleContest.round074;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/19
 */
public class D {

    private int carpetLen;
    private int len;
    private char[] arr;
    private int[][] memo;
    private int[] preWhiteCountArr;

    private int dp(int idx, int numCarpets) {
        if (numCarpets <= 0) {
            return 0;
        }

        if (len - idx <= carpetLen) {
            return preWhiteCountArr[len - 1] - (idx == 0 ? 0 : preWhiteCountArr[idx - 1]);
        }

        if (memo[idx][numCarpets] != -1) {
            return memo[idx][numCarpets];
        }

        int chooseRes = preWhiteCountArr[idx + carpetLen - 1] - (idx == 0 ? 0 : preWhiteCountArr[idx - 1]) +
                dp(idx + carpetLen, numCarpets - 1);
        int nonChooseRes = dp(idx + 1, numCarpets);

        memo[idx][numCarpets] = Math.max(chooseRes, nonChooseRes);
        return memo[idx][numCarpets];
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        arr = floor.toCharArray();
        this.len = arr.length;
        this.carpetLen = carpetLen;
        int whiteCount = 0;
        for (char num : arr) {
            if (num == '1') {
                whiteCount++;
            }
        }

        preWhiteCountArr = new int[len];
        preWhiteCountArr[0] = arr[0] == '1' ? 1 : 0;
        for (int i = 1; i < len ; i++) {
            if (arr[i] == '1') {
                preWhiteCountArr[i] = preWhiteCountArr[i - 1] + 1;
            } else {
                preWhiteCountArr[i] = preWhiteCountArr[i - 1];
            }
        }

        memo = new int[len][numCarpets + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        return whiteCount - dp(0, numCarpets);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
