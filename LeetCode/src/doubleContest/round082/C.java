package doubleContest.round082;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C {

    class Data {
        int a;
        int b;
        Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    private boolean isOk(Data[] datas, int target, long k) {
        long ans = 0;
        for (int i = 0; i < datas.length; i++) {
            int diff = Math.abs(datas[i].a - datas[i].b);
            if (diff > target) {
                ans += diff - target;
            }
            if (ans > k) {
                return false;
            }
        }
        return ans <= k;
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int len = nums1.length;
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            datas[i] = new Data(nums1[i], nums2[i]);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return Math.abs(o2.a - o2.b) - Math.abs(o1.a - o1.b);
            }
        });

        int k = k1 + k2;
        long ans = 0;

        int l = 0;
        int r = Math.abs(datas[0].a - datas[0].b);
        long target = r;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (isOk(datas, mid, k)) {
                target = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        for (int i = 0; i < datas.length; i++) {
            int diff = Math.abs(datas[i].a - datas[i].b);
            if (diff > target) {
                k -= diff - target;
            }
        }

        for (int i = 0; i < datas.length; i++) {
            long diff = Math.abs(datas[i].a - datas[i].b);
            if (diff >= target) {
                if (k > 0) {
                    ans += Math.max(0, target - 1) * Math.max(0, target - 1);
                    k--;
                } else {
                    ans += target * target;
                }
            } else {

                ans += diff * diff;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().minSumSquareDiff(new int[]{1,2,3,4}, new int[]{2,10,20,19}, 0, 0));
        System.out.println(new C().minSumSquareDiff(new int[]{1,4,10,12}, new int[]{5,8,6,9}, 1, 1));
    }

}
