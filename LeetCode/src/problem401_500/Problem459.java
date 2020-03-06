package problem401_500;

public class Problem459 {

    private boolean isEqual(String s, int from, int l) {
        for (int j = 0; j < l; j++) {
            if (s.charAt(j) != s.charAt(j + from)) {
                return false;
            }
        }
        return true;
    }

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int l = len / 2; l > 0; l--) {
            if (len % l != 0) {
                continue;
            }

            boolean isOk = true;
            for (int i = l; i <= len - l; i += l) {
                if (!isEqual(s, i, l)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return true;
            }
        }

        return false;
    }

}
