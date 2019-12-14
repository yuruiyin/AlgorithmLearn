package problem101_200;

public class Problem161 {

    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (Math.abs(sLen - tLen) > 1) {
            return false;
        }

        if (sLen == 0 && tLen == 0) {
            return false;
        }

        if (sLen != tLen) {
            // 需要插入一个字符或者删除一个字符
            String maxStr;
            String minStr;
            if (sLen > tLen) {
                maxStr = s;
                minStr = t;
            } else {
                maxStr = t;
                minStr = s;
            }

            int maxLen = maxStr.length();
            int minLen = minStr.length();

            int diffCount = 0;
            for (int i = 0, j = 0; i < minLen && j < maxLen; i++, j++) {
                char minChar = minStr.charAt(i);
                char maxChar = maxStr.charAt(j);

                if (minChar != maxChar) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                    i--;
                }
            }
            return true;
        } else  {
            // 需要替换一个字符
            int diffCount = 0;
            for (int i = 0; i < sLen; i++) {
                char sChar = s.charAt(i);
                char tChar = t.charAt(i);

                if (sChar != tChar) {
                    diffCount++;
                    if (diffCount > 1) {
                        return false;
                    }
                }
            }
            return diffCount == 1;
        }
    }

}
