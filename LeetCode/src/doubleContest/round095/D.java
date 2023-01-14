package doubleContest.round095;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class D {

    private boolean isOk(long[] arr, int r, int k, long min) {
        int len = arr.length;
        long pre = 0;
        LinkedHashMap<Integer, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            Iterator<Integer> keyIterator = map.keySet().iterator();
            while (keyIterator.hasNext()) {
                int key = keyIterator.next();
                if (key < i) {
                    pre -= map.get(key);
                    keyIterator.remove();
                } else {
                    break;
                }
            }
            if (arr[i] + pre < min) {
                long diff = min - (arr[i] + pre);
                if (k < diff) {
                    return false;
                }
                pre += diff;
                k -= diff;
                map.put(Math.min(len - 1, i + 2 * r), diff);
            }
        }
        return true;
    }

    public long maxPower(int[] stations, int r, int k) {
        // 二分
        long low = 0;
        long high = (long) 1e12;

        int len = stations.length;

        long[] preSumArr = new long[len];
        preSumArr[0] = stations[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + stations[i];
        }

        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(len - 1, i + r);
            arr[i] = preSumArr[right] - (left == 0 ? 0 : preSumArr[left - 1]);
        }

        long ans = -1;
        while (low <= high) {
            long mid = (low + high) >>> 1L;
            if (isOk(arr, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().maxPower(new int[]{4, 4, 4, 4}, 0, 3));
    }

}
