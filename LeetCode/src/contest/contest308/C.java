package contest.contest308;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C {

    public int garbageCollection(String[] garbage, int[] travel) {
        int len = garbage.length;
        int[][] countArr = new int[len]['P' + 1];
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                countArr[i][c]++;
            }
        }

        int ans = 0;
        int[] preSumArr = new int[travel.length];
        preSumArr[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            preSumArr[i] = preSumArr[i - 1] + travel[i];
        }

        Set<Character> set = new HashSet<>();
        set.add('M');
        set.add('P');
        set.add('G');
        int[] preIdxArr = new int['P' + 1];
        for (int i = 0; i < garbage.length; i++) {
            for (char c : set) {
                int count = countArr[i][c];
                if (count == 0) {
                    continue;
                }
                ans += count;
                int preIdx = preIdxArr[c];
                if (preIdx == i) {
                    continue;
                }
                ans += preSumArr[i - 1] - (preIdx == 0 ? 0 : preSumArr[preIdx - 1]);
                preIdxArr[c] = i;
            }
        }
        return ans;
    }

}
