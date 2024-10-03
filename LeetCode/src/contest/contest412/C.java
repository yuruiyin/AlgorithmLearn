package contest.contest412;

import utils.PrintUtil;
import utils.TreeMultiSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C {

    private static final int MOD = (int) (1e9 + 7);

    class Data {
        int idx;
        long value;

        Data(int idx, long value) {
            this.idx = idx;
            this.value = value;
        }
    }

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
        TreeMultiSet<Data> treeMultiSet = new TreeMultiSet<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.value == o2.value ? o1.idx - o2.idx : Long.compare(o1.value, o2.value);
            }
        });

        for (int i = 0; i < len; i++) {
            treeMultiSet.add(new Data(i, nums[i]));
        }

        List<Data> list = new ArrayList<>();
        int[] ansArr = new int[len];
        for (int i = 0; i < k; i++) {
            Data firstData = treeMultiSet.first();
            Data lastData = treeMultiSet.last();
            if (firstData.value * multiplier > lastData.value) {
                int left = k - i;
                int each = left / len;
                int mod = left % len;
                while (!treeMultiSet.isEmpty()) {
                    Data data = treeMultiSet.pollFirst();
                    data.value = (data.value * pow(multiplier, each, MOD)) % MOD;
                    if (mod > 0) {
                        data.value = (data.value * multiplier) % MOD;
                        mod--;
                    }
                    ansArr[data.idx] = (int) data.value;
                }
                break;
            } else {
                treeMultiSet.pollFirst();
                firstData.value *= multiplier;
                treeMultiSet.add(firstData);
            }
        }

        if (!treeMultiSet.isEmpty()) {
            while (!treeMultiSet.isEmpty()) {
                Data data = treeMultiSet.pollFirst();
                ansArr[data.idx] = (int) data.value;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] ansArr = new C().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2);
        PrintUtil.printIntArray(ansArr);
    }

}
