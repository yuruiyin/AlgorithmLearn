package contest.contest096;

public class Problem880 {

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private String s;

    private String recursive(int end, long k) {
        if (k == 0) {
            for (int j = end; j >= 0; j--) {
                char tmpC = s.charAt(j);
                if (isLowerCase(tmpC)) {
                    return tmpC + "";
                }
            }
        }

        long count = 0;
        for (int i = 0; i <= end; i++) {
            char c = s.charAt(i);
            long oldCount = count;
            if (isLowerCase(c)) {
                count++;
            } else {
                // 数字
                count *= c - '0';
            }

            if (count == k) {
                for (int j = i; j >= 0; j--) {
                    char tmpC = s.charAt(j);
                    if (isLowerCase(tmpC)) {
                        return tmpC + "";
                    }
                }
            }

            if (count > k) {
                return recursive(i - 1, k % oldCount);
            }
        }

        return "";
    }

    public String decodeAtIndex(String s, int k) {
        this.s = s;
        int len = s.length();
        return recursive(len - 1, k);
    }

}
