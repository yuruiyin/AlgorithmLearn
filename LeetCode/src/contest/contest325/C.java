package contest.contest325;

import java.util.Arrays;

public class C {

    private boolean isOk(int[] arr, int k, int min) {
        int len = arr.length;
        int count = 1;
        int curIdx = 1;
        int pre = arr[0];
        boolean isFound1 = true;
        while (count < k) {
            boolean tmpIsOk = false;
            for (int i = curIdx; i < len; i++) {
                if (arr[i] - pre >= min) {
                    tmpIsOk = true;
                    curIdx = i + 1;
                    pre = arr[i];
                    break;
                }
            }
            if (!tmpIsOk) {
                isFound1 = false;
                break;
            }
            count++;
        }

        return isFound1;
    }

    public int maximumTastiness(int[] arr, int k) {
        // 二分
        int len = arr.length;
        Arrays.sort(arr);
        int l = 0;
        int r = arr[len - 1] - arr[0];
        int ansMax = 0;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(arr, k, mid)) {
                ansMax = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ansMax;
    }

}
