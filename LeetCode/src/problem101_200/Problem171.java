package problem101_200;

public class Problem171 {

    public int titleToNumber(String s) {
        // 26进制
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = i + 1;
        }

        int len = s.length();
        int ans = 0;
        int value = 1;
        for (int i = len - 1; i >= 0; i--) {
            char c = s.charAt(i);
            ans += arr[c - 'A'] * value;
            value *= 26;
        }

        return ans;
    }

}
