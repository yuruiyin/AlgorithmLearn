package contest.contest174;

import java.util.Arrays;
import java.util.Comparator;

public class Problem02 {

    public int minSetSize(int[] arr) {
        int[] countArr = new int[100001];
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            countArr[arr[i]]++;
        }

        Arrays.sort(countArr);

        int ans = 0;
        int sum = 0;
        boolean begin = false;
        for (int i = 100000; i >= 0; i--) {
            if (countArr[i] != 0) {
                begin = true;
            }

            if (begin) {
                sum += countArr[i];
                ans++;
                if (sum >= len / 2) {
                    break;
                }
            }
        }

        return ans;
    }

}
