package contest.contest148;

public class Problem1147 {

    public int longestDecomposition(String text) {
        if (text.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = text.length() - 1;

        int ans = 1;

        while (left < right) {
            char leftChar = text.charAt(left);

            int mid = (left + right) >> 1;
            int i;
            boolean isFound = false;
            for (i = right; i > mid; i--) {
                if (text.charAt(i) == leftChar) {
                    int len = right - i + 1;
                    String leftStr = text.substring(left, left + len);
                    String rightStr = text.substring(i, right + 1);
                    if (leftStr.equals(rightStr)) {
                        ans += 2;
                        left = left + len;
                        right = right - len;
                        isFound = true;
                        break;
                    }
                }
            }

            if (!isFound) {
                break;
            }
        }

        return left <= right ? ans : ans - 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1147().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(new Problem1147().longestDecomposition("merchant"));
        System.out.println(new Problem1147().longestDecomposition("elvtoelvto"));
    }
}
