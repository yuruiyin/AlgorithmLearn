package contest.contest443;

public class C {

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

    }

    // 1.1 奇数个字符，中间字符在s, 左边一定是连续的，右边一定是先连续s，再到t
    private int getAns1(String s, String t) {
        StrHash strHash1 = new StrHash(s.toCharArray());
        String reverseT = new StringBuilder(t).reverse().toString();
        StrHash strHash2 = new StrHash(reverseT.toCharArray());

        int len1 = s.length();
        int len2 = t.length();
        int ansMax = 1;
        for (int m = 0; m < len1; m++) {
            int targetOffset = 0;
            for (int offset = 1; offset <= Math.min(len1 - m - 1, m); offset++) {
                if (s.charAt(m - offset) != s.charAt(m + offset)) {
                    break;
                }
                targetOffset = offset;
            }

            // 往t了，根据长度二分查找
            int l = 1;
            int r = m - targetOffset;
            int oldTargetOffset = targetOffset;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                // [m - targetOffset - mid, m - targetOffset - 1]
                boolean isOk = false;
                long leftHash = strHash1.getSubStrHash(m - oldTargetOffset - mid, m - oldTargetOffset - 1);
                for (int i = 0; i < len2 - mid + 1; i++) {
                    // [i, i + mid - 1]
                    long rightHash = strHash2.getSubStrHash(i, i + mid - 1);
                    if (leftHash == rightHash) {
                        isOk = true;
                        break;
                    }
                }

                if (isOk) {
                    targetOffset = targetOffset + mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            ansMax = Math.max(ansMax, targetOffset * 2 + 1);
        }

        return ansMax;
    }

    // 2. 偶数个字符，中间两个字符可能是都在s,或者都在t，或者一个在s，一个在t
    private int getAns2(String s, String t) {
        StrHash strHash1 = new StrHash(s.toCharArray());
        String reverseT = new StringBuilder(t).reverse().toString();
        StrHash strHash2 = new StrHash(reverseT.toCharArray());

        int len1 = s.length();
        int len2 = t.length();
        int ansMax = 0;
        for (int m = 0; m < len1; m++) {
            int targetOffset = 0;
            for (int offset = 0; offset <= Math.min(len1 - m - 2, m); offset++) {
                if (m == len1 - 1) {
                    break;
                }
                if (s.charAt(m - offset) != s.charAt(m + offset + 1)) {
                    break;
                }
                targetOffset = offset + 1;
            }

            // 往t了，根据长度二分查找
            int l = 1;
            int r = m - targetOffset + 1;
            int oldTargetOffset = targetOffset;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                // [m - targetOffset - mid, m - targetOffset - 1]
                boolean isOk = false;
                long leftHash = strHash1.getSubStrHash(m + 1 - oldTargetOffset - mid, m - oldTargetOffset);
                for (int i = 0; i < len2 - mid + 1; i++) {
                    // [i, i + mid - 1]
                    long rightHash = strHash2.getSubStrHash(i, i + mid - 1);
                    if (leftHash == rightHash) {
                        isOk = true;
                        break;
                    }
                }

                if (isOk) {
                    targetOffset = targetOffset + mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            ansMax = Math.max(ansMax, targetOffset * 2);
        }

        return ansMax;
    }

    public int longestPalindrome(String s, String t) {
        // 分类讨论
        // 1. 奇数个字符，固定某个字符为中间字符（可能在s，可能在t）
        // 2. 偶数个字符，中间两个字符可能是都在s,或者都在t，或者一个在s，一个在t

        // 1. 奇数
        int ans1 = getAns1(s, t);
        int ans2 = getAns1(new StringBuilder(t).reverse().toString(), new StringBuilder(s).reverse().toString());

        // 2. 偶数
        int ans3 = getAns2(s, t);
        int ans4 = getAns2(new StringBuilder(t).reverse().toString(), new StringBuilder(s).reverse().toString());

        return Math.max(Math.max(ans1, ans2), Math.max(ans3, ans4));
    }

    public static void main(String[] args) {
        // s = "abcde", t = "ecdba"
//        System.out.println(new C().longestPalindrome("a", "a"));
        System.out.println(new C().longestPalindrome("abcde", "ecdba"));
    }

}
