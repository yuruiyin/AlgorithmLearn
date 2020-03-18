import java.util.HashSet;
import java.util.Set;

/**
 * LintCode157
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode157_1 {

    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        int len = str.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

}
