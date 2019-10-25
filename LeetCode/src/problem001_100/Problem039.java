package problem001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem039 {

    private List<List<Integer>> ansList;

    private void backTrack(int from, int[] nums, int target, int curSum, List<Integer> tmpList) {
        if (curSum == target) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        int n = nums.length;

        for (int i = from; i < n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int sum = curSum + nums[i];
            if (sum > target) { // 因为数字是排序的，如果当前sum超过target，那么后面肯定也超过
                return;
            }
            tmpList.add(nums[i]);
            backTrack(i, nums, target, sum, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ansList = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, target, 0, new ArrayList<>());
        return ansList;
    }

    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem039().combinationSum(new int[]{2,3,6,7}, 7);
        
        for (List<Integer> list: ansList) {
            for (Integer num : list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }

        List<List<Integer>> ansList1 = new Problem039().combinationSum(new int[]{2,3,5}, 8);

        for (List<Integer> list: ansList1) {
            for (Integer num : list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

}
