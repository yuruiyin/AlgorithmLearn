package contest.contest319;

public class D_1 {

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

    private boolean isPalindrome(char[] arr, int left, int right) {
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int maxPalindromes(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ans = 0;
        int l = 0;
        String reverseStr = new StringBuilder(s).reverse().toString();
        char[] reverseArr = reverseStr.toCharArray();
        StrHash reverseStrHash = new StrHash(reverseArr);
        StrHash strHash = new StrHash(arr);
        for (int i = k - 1; i < len;) {
            int left = i - k + 1;
            boolean isFound = false;
            while (left >= l) {
                int right = i;
                int tmpLen = right - left + 1;
                int tmpL = left + tmpLen / 2 + tmpLen % 2;
                long rightHalfHash = strHash.getSubStrHash(tmpL, right);
                long reverseHash = reverseStrHash.getSubStrHash(len - tmpL + tmpLen % 2, len - left - 1);
                if (rightHalfHash == reverseHash) {
                    ans++;
                    l = i + 1;
                    i += k;
                    isFound = true;
                    break;
                }
                left--;
            }
            if (!isFound) {
                i++;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
//        System.out.println(new D_1().maxPalindromes("abaccdbbd", 3));
        long start = System.currentTimeMillis();
        System.out.println("abcd".repeat(500));
        System.out.println(new D_1().maxPalindromes("abcd".repeat(500), 1000));
        System.out.println("time cost: " + (System.currentTimeMillis() - start));
    }

}
