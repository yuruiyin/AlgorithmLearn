package doubleContest.round101;

import java.util.*;

public class C {

//    private int gcd(int m, int n) {
//        return m % n == 0 ? n : gcd(n, m % n);
//    }

    private int gcd(int m, int n) {
        while (m % n != 0) {
            int tmp = n;
            n = m % n;
            m = tmp;
        }
        return n;
    }

    public long makeSubKSumEqual(int[] arr, int k) {
        int len = arr.length;
        if (k == len) {
            return 0;
        }

        int gcd = gcd(len, k);
        long ans = 0;
        for (int i = 0; i < gcd; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = i; j < len; j += gcd) {
                list.add(arr[j]);
            }
            Collections.sort(list);
            int mid = list.get(list.size() >>> 1);
            for (int num : list) {
                ans += Math.abs(num - mid);
            }
        }
        return ans;
    }

}
