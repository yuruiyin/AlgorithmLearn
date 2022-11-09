package doubleContest.round086;

public class B {

    private boolean isPalindrome(StringBuilder sb) {
        int l = 0;
        int r = sb.length() - 1;
        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            int num = n;
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int mod = num % i;
                sb.append(mod);
                num /= i;
            }
            if (!isPalindrome(sb)) {
                return false;
            }
        }
        return true;
    }



}
