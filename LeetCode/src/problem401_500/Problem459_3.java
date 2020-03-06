package problem401_500;

public class Problem459_3 {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int l = len / 2; l > 0; l--) {
            if (len % l != 0) {
                continue;
            }

            String str = s.substring(0, l);

            boolean isOk = true;
            for (int i = l; i <= len - l; i += l) {
                if (!s.substring(i, i + l).equals(str)) {
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
