import java.util.*;

/**
 * LintCode1689
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode1689 {

    private int dp(List<Integer> list, int idx, int k, int target, int[] suffixSumArr, Map<Long, Integer> memo) {
        if (k == 0) {
            return target == 0 ? 1 : 0;
        }

        int size = list.size();
        if (idx == size || size - idx < k || target < list.get(idx) || target > suffixSumArr[idx]) {
            return 0;
        }

        long key = target * size * size + idx * size + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int chooseRes = dp(list, idx + 1, k - 1, target - list.get(idx), suffixSumArr, memo);
        int nonChooseRes = dp(list, idx + 1, k, target, suffixSumArr, memo);
        int sum = chooseRes + nonChooseRes;
        memo.put(key, sum);
        return sum;
    }

    private int[] calcSuffixSum(List<Integer> list) {
        int size = list.size();
        int[] suffixSumArr = new int[size];
        if (size == 0) {
            return suffixSumArr;
        }

        suffixSumArr[size - 1] = list.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + list.get(i);
        }
        return suffixSumArr;
    }

    public int getAns(int[] arr, int k, int target) {
        // write your code here
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        Arrays.sort(arr);
        for (int num : arr) {
            if (num % 2 == 1) {
                oddList.add(num);
            } else {
                evenList.add(num);
            }
        }

        int oddCount = dp(oddList, 0, k, target, calcSuffixSum(oddList), new HashMap<>());
        int evenCount = dp(evenList, 0, k, target, calcSuffixSum(evenList), new HashMap<>());
        return oddCount + evenCount;
    }

}
