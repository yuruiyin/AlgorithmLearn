package problem001_100;

public class Problem005_2 {

    // 中心扩散法，遍历每个索引，从这个索引向两边扩散，看最多能匹配多少字符。
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        char[] arr = s.toCharArray();
        int ansStart = 0;
        int maxLen = 1;
        int maxIndex = n - (maxLen+1) / 2;

        for (int mid = 0; mid < maxIndex; mid++) {
            // 先寻找从mid开始连续相同的字符，当成回文串的中间部分字符
            int left = mid;
            int right = mid;
            while (right < n - 1 && arr[right + 1] == arr[left]) {
                right++;
            }

            mid = right; // 下次直接跳过当前连续的字符
            int len = right - left + 1;
            while ((--left) >= 0 && (++right) < n) {
                if (arr[left] != arr[right]) {
                    break;
                }
                len += 2;
            }

            if (len > maxLen) {
                maxLen = len;
                ansStart = left + 1;
                maxIndex = n - (maxLen+1) / 2;
            }
        }

        return s.substring(ansStart, ansStart + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(new Problem005_2().longestPalindrome("babad"));
    }

}
