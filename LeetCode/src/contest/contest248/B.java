package contest.contest248;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/4
 */
public class B {

    private boolean isOk(int[] dist, int[] speed, long target) {
        int n = dist.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            long value = dist[i] - (target - 1) * speed[i];
            if (value <= 0) {
                count++;
            }
        }
        return count < target;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = dist[i] / speed[i] + (dist[i] % speed[i] == 0 ? 0 : 1);
        }

        Arrays.sort(arr);
        int ansMax = n;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= i) {
                ansMax = i;
                break;
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new B().eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));
    }


}
