import java.util.HashSet;
import java.util.Set;

/**
 * LintCode1658
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode1658 {

    public boolean isLegalIdentifier(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            set.add((char) ('a' + i));
            set.add((char) ('A' + i));
        }

        for (int i = 0; i < 10; i++) {
            set.add((char) ('0' + i));
        }

        set.add('_');

        if (Character.isDigit(str.charAt(0))) {
            return false;
        }

        for (char c: str.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }

}

