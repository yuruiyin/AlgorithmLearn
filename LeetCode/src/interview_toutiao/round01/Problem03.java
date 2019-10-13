package interview_toutiao.round01;

public class Problem03 {

    public int numDecodings(String s) {
        int len = s.length();
        int ans = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                ans += 9;

                if (i < len - 1) {
                    char nextC = s.charAt(i + 1);
                    if (nextC == '*') {
                        ans += 9 + 6;
                    } else if (nextC >= '7') {
                        // 17 or 18 or 19
                        ans += 1;
                    } else {
                        ans += 2;
                    }
                }
            }

            if (!(c == '1' || c == '2')) {
                continue;
            }

            // c == '1' or c == '2'
            if (i == len - 1) {
                break;
            }

            char nextC = s.charAt(i + 1);
            if (nextC == '*') {
                if (c == '1') {
                    ans += 9;
                } else {
                    ans += 6;
                }
            } else if (nextC >= 7) {
                if (c == '1') {
                    ans += 1;
                }
            } else {
                ans += 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem1215().numDecodings("*"));
//        System.out.println(new Problem1215().numDecodings("1*"));
        System.out.println(new Problem03().numDecodings("**"));
    }

}
