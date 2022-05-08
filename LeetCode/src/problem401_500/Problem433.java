package problem401_500;

import java.util.*;

public class Problem433 {

    private Set<String> set;
    private char[] charArr = new char[]{'A', 'C', 'G', 'T'};
    private int ansMin = Integer.MAX_VALUE;

    private void rec(String start, String end, Set<String> visitedSet, int level) {
        if (start.equals(end)) {
            ansMin = Math.min(ansMin, level);
            return;
        }

        visitedSet.add(start);

        //  ['A', 'C', 'G', 'T']
        for (int i = 0; i < 8; i++) {
            for (char c : charArr) {
                if (start.charAt(i) == c) {
                    continue;
                }
                String next = start.substring(0, i) + c + start.substring(i + 1);
                if (!set.contains(next) || visitedSet.contains(next)) {
                    continue;
                }
                rec(next, end, visitedSet, level + 1);
            }
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        set = new HashSet<>();
        set.addAll(Arrays.asList(bank));
        rec(start, end, new HashSet<>(), 0);
        return ansMin == Integer.MAX_VALUE ? -1 : ansMin;
    }

}
