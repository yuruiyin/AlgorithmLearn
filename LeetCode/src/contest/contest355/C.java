package contest.contest355;

import java.util.*;

public class C {

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        int n = usageLimits.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.min(usageLimits.get(i), n);
        }
        sortDesc(arr);
        int l = 1;
        int r = arr[0];
        while (l < r) {
            int mid = (l + r) >>> 1;
            int j = 0;
            for (int i = mid; i >= 1; i--) {
                // todo
            }
        }

        return 0;
    }

}
