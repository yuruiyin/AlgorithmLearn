package lcof;

public class Lcof046 {

    private char[] arr;
    private int len;
    private int[] memo;

    private int dp(int idx) {
        if (idx == len) {
            return 1;
        }

        if (memo[idx] != 0) {
            return memo[idx];
        }

        int chooseOne = dp(idx + 1);
        if (idx == len - 1 || arr[idx] == '0') {
            return chooseOne;
        }

        int twoDigitNum = (arr[idx] - '0') * 10 + (arr[idx + 1] - '0');
        if (twoDigitNum > 25) {
            memo[idx] = chooseOne;
            return chooseOne;
        }

        int chooseTwo = dp(idx + 2);
        memo[idx] = chooseOne + chooseTwo;
        return memo[idx];
    }

    public int translateNum(int num) {
        arr = String.valueOf(num).toCharArray();
        len = arr.length;
        memo = new int[len];
        return dp(0);
    }

}
