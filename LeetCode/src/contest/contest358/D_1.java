package contest.contest358;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class D_1 {

    private static final int MOD = (int) (1e9 + 7);

    private static int[] primeScoreArr;

    /**
     * 获取所有素数（高效解法）
     * 获取所有质数（高效解法）
     */
    private List<Integer> getPrimeList(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    private void calcPrimeScore() {
        if (primeScoreArr != null) {
            return;
        }
        int N = 100000;
        primeScoreArr = new int[N + 1];
        List<Integer> primeList = getPrimeList(N);
        boolean[] isPrime = new boolean[N + 1];
        for (int num : primeList) {
            isPrime[num] = true;
        }
        primeScoreArr[2] = 1;
        primeScoreArr[3] = 1;
        for (int i = 4; i <= N; i++) {
            int end = (int) Math.sqrt(i);
            int count = 0;
            for (int j = 2; j <= end; j++) {
                if (i % j != 0) {
                    continue;
                }
                if (isPrime[j]) {
                    count++;
                }
                int another = i / j;
                if (isPrime[another] && another != j) {
                    count++;
                }
            }

            if (isPrime[i]) {
                count++;
            }

            primeScoreArr[i] = count;
        }
    }

    // 使用单调栈获取右边第一个比当前元素大的元素的索引
    public static int[] getRightFirstGreaterIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] rightFirstGreaterIdxArr = new int[len];
        Arrays.fill(rightFirstGreaterIdxArr, len);

        for (int i = len - 1; i >= 0; i--) {
            while (stackSize != 0 && height[stack[stackSize - 1]] <= height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                rightFirstGreaterIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return rightFirstGreaterIdxArr;
    }

    public int[] getLeftFirstGreaterIdxArr(int[] height) {
        int len = height.length;
        int[] stack = new int[len];
        int stackSize = 0;
        int[] leftFirstGreaterIdxArr = new int[len];
        Arrays.fill(leftFirstGreaterIdxArr, -1);

        for (int i = 0; i < len; i++) {
            while (stackSize != 0 && height[stack[stackSize - 1]] < height[i]) {
                stackSize--;
            }

            if (stackSize != 0) {
                leftFirstGreaterIdxArr[i] = stack[stackSize - 1];
            }
            stack[stackSize++] = i;
        }
        return leftFirstGreaterIdxArr;
    }

    class Data {
        int value;
        long count;
        Data(int value, long count) {
            this.value = value;
            this.count = count;
        }
    }

    // 快速pow 二分
    private long pow(long x, long n, int mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % mod;
            }

            x = (x * x) % mod;
            n >>= 1;
        }
        return res % mod;
    }

    public int maximumScore(List<Integer> nums, int k) {
        // 先求[1, 100000]以内每个数的质数分数
        calcPrimeScore();
        int len = nums.size();
        int[] primeArr = new int[len];
        for (int i = 0; i < len; i++) {
            primeArr[i] = primeScoreArr[nums.get(i)];
        }

        int[] rightFirstGreaterIdxArr = getRightFirstGreaterIdxArr(primeArr);
        int[] leftFirstGreaterIdxArr = getLeftFirstGreaterIdxArr(primeArr);
        Data[] datas = new Data[len];
        for (int i = 0; i < len; i++) {
            long leftCount = i - leftFirstGreaterIdxArr[i];
            long rightCount = rightFirstGreaterIdxArr[i] - i;
            datas[i] = new Data(nums.get(i), leftCount * rightCount);
        }

        Arrays.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.value - o1.value;
            }
        });

        long ansMax = 1;
        for (int i = 0; i < len; i++) {
            long count = datas[i].count;
            long curCount = Math.min(count, k);
            long value = pow(datas[i].value, curCount, MOD);
            ansMax = (ansMax * value) % MOD;
            k -= curCount;
            if (k <= 0) {
                break;
            }
        }
        return (int) (ansMax % MOD);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
//        [3289,2832,14858,22011]
//        6
        list.add(3289);
        list.add(2832);
        list.add(14858);
        list.add(22011);
        int ans = new D_1().maximumScore(list, 6);
        System.out.println(ans);
    }

}
