package problem101_200;

public class Problem171_1 {

    public int titleToNumber(String s) {
        // 26进制
        int ans = 0;
        for (char c: s.toCharArray()) {
            ans *= 26;
            ans += c - 64;
        }
        return ans;
    }

}
