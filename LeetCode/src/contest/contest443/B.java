package contest.contest443;

public class B {

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public int longestPalindrome(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int ansMax = 1;

        for (int l1 = 0; l1 <= len1; l1++) {
            for (int ii = 0; ii < len1 - l1 + 1; ii++) {
                // [ii, ii + l1 - 1]
                String sub1 = s.substring(ii, ii + l1);
                for (int l2 = 0; l2 <= len2; l2++) {
                    for (int jj = 0; jj < len2 - l2 + 1; jj++) {
                        String sub2 = t.substring(jj, jj + l2);
                        String str = sub1 + sub2;
                        if (isPalindrome(str)) {
                            ansMax = Math.max(ansMax, l1 + l2);
                        }
                    }
                }
            }
        }

        return ansMax;

    }

}
