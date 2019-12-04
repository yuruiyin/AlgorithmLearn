package problem601_700;

// 中心扩展法
public class Problem647_1 {

    private String s;
    private int len;

    private int getCount(int start, int end) {
        int count = 0;
        while (start >= 0 && end < len && s.charAt(start--) == s.charAt(end++)) {
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        this.s = s;
        len = s.length();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            ans += getCount(i, i);
            ans += getCount(i, i+1);
        }

        return ans;
    }

}
