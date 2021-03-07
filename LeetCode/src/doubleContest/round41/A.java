package doubleContest.round41;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/12
 */
public class A {

    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        for (String word : words) {
            boolean isOk = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                ans++;
            }
        }

        return ans;
    }

}
