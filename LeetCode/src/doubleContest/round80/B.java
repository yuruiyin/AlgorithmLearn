package doubleContest.round80;

import java.util.Arrays;

public class B {

    private int findFirstBiggerOrEqualIndex(int[] potions, int curSpell, long success) {
        int l = 0;
        int r = potions.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            long midVal = potions[mid];
            if (midVal * curSpell < success) {
                l = mid + 1;
            } else {
                if (mid == 0 || (long)potions[mid - 1] * curSpell < success) {
                    return mid;
                }
                r = mid - 1;
            }
        }
        return -1;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] ansArr = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = findFirstBiggerOrEqualIndex(potions, spells[i], success);
            if (idx != -1) {
                ansArr[i] = potions.length - idx;
            }
        }
        return ansArr;
    }

}
