package problem001_100;

/**
 * Problem08_1
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Problem08_1 {

    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int INT_MIN = Integer.MIN_VALUE;

    public int myAtoi(String str) {
        char[] arr = str.trim().toCharArray();
        int len = arr.length;
        if (len == 0) {
            return 0;
        }

        int sign = arr[0] == '-' ? -1 : 1;
        int fromIdx = arr[0] != '+' && arr[0] != '-' ? 0 : 1;
        int ans = 0;
        for (int i = fromIdx; i < len && Character.isDigit(arr[i]); i++) {
            int value = sign * ans;
            if (value > INT_MAX / 10 || value == INT_MAX / 10 && arr[i] > '7') {
                return INT_MAX;
            } else if (value < INT_MIN / 10 || value == INT_MIN / 10 && arr[i] > '8') {
                return INT_MIN;
            }

            ans *= 10;
            ans += arr[i] - '0';
        }

        return sign * ans;
    }

}
