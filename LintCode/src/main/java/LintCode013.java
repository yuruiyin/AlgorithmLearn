/**
 * LintCode013
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode013 {

    public int strStr(String source, String target) {
        int sourceLen = source.length();
        int targetLen = target.length();
        if (sourceLen == 0 && targetLen == 0) {
            return 0;
        }
        for (int i = 0; i < sourceLen; i++) {
            if (sourceLen - i < targetLen) {
                return -1;
            }

            boolean isOk = true;
            for (int j = 0; j < targetLen; j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return i;
            }
        }

        return -1;
    }

}
