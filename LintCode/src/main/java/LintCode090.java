import java.util.*;

/**
 * LintCode090
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode090 {

    private int[] arr;
    private int len;
    private int[] suffixSumArr;
    private Map<Long, List<List<Integer>>> memo;

    private List<List<Integer>> backTrack(int idx, int k, int target) {
        if (k == 0) {
            return target == 0 ? new ArrayList<>() : null;
        }

        if (idx == len || k > len - idx || suffixSumArr[idx] < target || target < arr[idx]) {
            return null;
        }

        long key = target * len * len + idx * len + k;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<List<Integer>> chooseRes = backTrack(idx + 1, k - 1, target - arr[idx]);
        List<List<Integer>> nonChooseRes = backTrack(idx + 1, k, target);
        List<List<Integer>> ansList = new ArrayList<>();

        if (chooseRes != null) {
            if (chooseRes.isEmpty()) {
                ansList.add(new ArrayList<>(Arrays.asList(arr[idx])));
            } else {
                for (List<Integer> list : chooseRes) {
                    List<Integer> addedList = new ArrayList<>();
                    addedList.add(arr[idx]);
                    addedList.addAll(list);
                    ansList.add(addedList);
                }
            }
        }

        if (nonChooseRes != null) {
            ansList.addAll(nonChooseRes);
        }

        if (ansList.isEmpty()) {
            ansList = null;
        }

        memo.put(key, ansList);
        return ansList;
    }

    private void calcSuffixSum() {
        suffixSumArr = new int[len];
        suffixSumArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            suffixSumArr[i] = suffixSumArr[i + 1] + arr[i];
        }
    }

    public List<List<Integer>> kSumII(int[] nums, int k, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        this.arr = nums;
        this.len = arr.length;
        calcSuffixSum();
        memo = new HashMap<>();
        Arrays.sort(arr);
        return backTrack(0, k, target);
    }

}
