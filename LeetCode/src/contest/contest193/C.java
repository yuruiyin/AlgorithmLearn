package contest.contest193;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/14
 */
public class C {

    private final static int MAX = 1000000000;

    private boolean isOk(int[] bloomDay, int m, int k, int day) {
        int n = bloomDay.length;
        int flowerCount = 0;
        int tmpCount = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] > day) {
                tmpCount = 0;
            } else {
                tmpCount++;
                if (tmpCount == k) {
                    flowerCount++;
                    if (flowerCount == m) {
                        return true;
                    }
                    tmpCount = 0;
                }
            }
        }

        return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) {
            return -1;
        }

        int low = 1;
        int high = MAX;
        int ansMin = -1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isOk(bloomDay, m, k, mid)) {
                ansMin = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ansMin;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().minDays(new int[]{97, 83}, 2, 1));
    }

}
