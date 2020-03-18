import java.util.HashSet;
import java.util.Set;

/**
 * LintCode157
 *
 * @author: yry
 * @date: 2020/3/17
 */
public class LintCode157 {

    public boolean isUnique(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }

        Set<Character> visited = new HashSet<>();
        for (char c: str.toCharArray()) {
            if (visited.contains(c)) {
                return false;
            }
            visited.add(c);
        }
        return true;
    }

}
