package problem1001_1100;

public class Problem1003 {

    public boolean isValid(String s) {
        int len = s.length();
        StringBuilder lastSb = new StringBuilder(s);

        while (lastSb.length() > 0) {
            boolean hasAbc = false;
            StringBuilder curSb = new StringBuilder();
            int lastSbLen = lastSb.length();
            for (int i = 0; i < lastSbLen;) {
                if (i + 1 < lastSbLen && i + 2 < lastSbLen && lastSb.substring(i, i + 3).equals("abc")) {
                    i += 3;
                    hasAbc = true;
                    continue;
                }

                curSb.append(lastSb.charAt(i));
                i++;
            }

            if(!hasAbc) {
                return false;
            }

            lastSb = curSb;
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1003().isValid("aabcbc"));
        System.out.println(new Problem1003().isValid("abcabcababcc"));
        System.out.println(new Problem1003().isValid("abccba"));
        System.out.println(new Problem1003().isValid("cababc"));
        System.out.println(new Problem1003().isValid("abc"));
        System.out.println(new Problem1003().isValid("aaabcbcbc"));

    }
    
}
