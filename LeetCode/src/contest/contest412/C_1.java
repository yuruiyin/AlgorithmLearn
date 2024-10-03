package contest.contest412;

import utils.TreeMultiSet;

import java.util.Comparator;

public class C_1 {

    private static final int MOD = (int) (1e9 + 7);

    // 快速幂
    public static int pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % mod;
            }

            x = x * x % mod;
            n >>>= 1;
        }
        return (int) res % mod;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }

        int len = nums.length;
        long[] arr = new long[len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }

        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return arr[o1] == arr[o2] ? o1 - o2 : Long.compare(arr[o1], arr[o2]);
            }
        });

        for (int i = 0; i < len; i++) {
            treeMultiSet.add(i);
        }

        int[] ansArr = new int[len];
        boolean isOk = false;
        for (int i = 0; i < k; i++) {
            int firstDataIdx = treeMultiSet.first();
            int lastDataIdx = treeMultiSet.last();
            if (arr[firstDataIdx] * multiplier > arr[lastDataIdx]) {
                int left = k - i;
                int each = left / len;
                int mod = left % len;
                for (int idx : treeMultiSet) {
                    ansArr[idx] = (int) ((arr[idx] * pow(multiplier, each, MOD)) % MOD);
                    if (mod > 0) {
                        ansArr[idx] = (int) ((ansArr[idx] * (long) multiplier) % MOD);
                        mod--;
                    }
                }
                isOk = true;
                break;
            } else {
                treeMultiSet.pollFirst();
                arr[firstDataIdx] *= multiplier;
                treeMultiSet.add(firstDataIdx);
            }
        }

        if (!isOk) {
            for (int idx : treeMultiSet) {
                ansArr[idx] = (int) arr[idx];
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println(new C_1().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2));
    }

}
