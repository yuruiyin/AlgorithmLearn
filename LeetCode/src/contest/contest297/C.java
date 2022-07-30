package contest.contest297;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class C {

    private boolean rec(int curIdx, int[] arr, int max, int[] cookies) {
        if (curIdx == cookies.length) {
            return true;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + cookies[curIdx] <= max) {
                arr[i] += cookies[curIdx];
                boolean ok = rec(curIdx + 1, arr, max, cookies);
                if (ok) {
                    return true;
                }
                arr[i] -= cookies[curIdx];
            }
        }
        return false;
    }

    private boolean isOk(int[] cookies, int k, int max) {
        return rec(0, new int[k], max, cookies);
    }

    public int distributeCookies(int[] cookies, int k) {
        int len = cookies.length;
        Arrays.sort(cookies);
        int l = 0;
        int r = 0;
        for (int i = len - 1; i >= k - 1; i--) {
            r += cookies[i];
        }

        int ansMin = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(cookies, k, mid)) {
                ansMin = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ansMin;
    }

}
