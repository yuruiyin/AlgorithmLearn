package contest.contest338;

import java.util.ArrayList;
import java.util.List;

public class B_1 {

    private static int[] primes;

    private int[] getAllPrimes(int n) {
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

        int[] arr = new int[primeList.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = primeList.get(i);
        }

        return arr;
    }

    private int findFirstBiggerIdx(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > target) {
                if (mid == 0 || arr[mid - 1] <= target) {
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public boolean primeSubOperation(int[] nums) {
        if (primes == null) {
            primes = getAllPrimes(1000);
        }

        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= nums[i + 1]) {
                int firstBiggerIdx = findFirstBiggerIdx(primes, nums[i] - nums[i + 1]);
                if (firstBiggerIdx == -1 || primes[firstBiggerIdx] >= nums[i]) {
                    return false;
                }
                nums[i] -= primes[firstBiggerIdx];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new B_1().primeSubOperation(new int[]{1, 2, 3}));
    }

}
