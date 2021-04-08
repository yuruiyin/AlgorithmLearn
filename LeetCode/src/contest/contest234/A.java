package contest.contest234;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/28
 */
public class A {

    private String removeLeadingZeros(StringBuilder sb) {
        boolean hasNonZero = false;
        StringBuilder ansSb = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                hasNonZero = true;
            }

            if (hasNonZero) {
                ansSb.append(sb.charAt(i));
            }
        }

        return ansSb.toString();
    }

    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        char[] arr = word.toCharArray();
        int len = arr.length;
        StringBuilder tmpSb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!Character.isDigit(arr[i])) {
                if (i == 0 || !Character.isDigit(arr[i-1])) {
                    continue;
                }

                set.add(removeLeadingZeros(tmpSb));
                tmpSb = new StringBuilder();
                continue;
            }

            tmpSb.append(arr[i]);
        }

        if (tmpSb.length() > 0) {
            set.add(removeLeadingZeros(tmpSb));
        }

        return set.size();
    }

}
