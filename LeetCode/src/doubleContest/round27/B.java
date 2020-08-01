package doubleContest.round27;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/30
 */
public class B {

    public boolean hasAllCodes(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - k; i++) {
            String subStr = s.substring(i, i + k);
            set.add(subStr);
        }

        return set.size() == (1 << k);
    }

}
