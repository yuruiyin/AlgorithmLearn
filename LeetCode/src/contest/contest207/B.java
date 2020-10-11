package contest.contest207;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/20
 */
public class B {

    private char[] arr;
    private String s;
    private int len;

    private int rec(Set<String> visitedSet, int cur) {
        if (cur == len) {
            return 0;
        }

        int ansMax = 0;
        for (int i = cur; i < len; i++) {
            String str = s.substring(cur, i + 1);
            if (visitedSet.contains(str)) {
                continue;
            }

            visitedSet.add(str);
            ansMax = Math.max(ansMax, 1 + rec(visitedSet, i + 1));
            visitedSet.remove(str);
        }

        return ansMax;
    }

    public int maxUniqueSplit(String s) {
        arr = s.toCharArray();
        this.s = s;
        this.len = arr.length;
        return rec(new HashSet<>(), 0);
    }

}
