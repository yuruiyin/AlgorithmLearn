package problem001_100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem040 {

    private List<List<Integer>> ansList;

    private void backTrack(int from, int[] nums, int target, int curSum, List<Integer> tmpList) {
        if (curSum == target) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        int len = nums.length;
        for (int i = from; i < len; i++) {
            if (i > from && nums[i] == nums[i-1]) {
                continue;
            }

            int sum = curSum + nums[i];
            if (sum > target) {
                return;
            }

            tmpList.add(nums[i]);
            backTrack(i + 1, nums, target, sum, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ansList = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0, candidates, target, 0, new ArrayList<>());
        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem040().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        PrintUtil.printIntListList(ansList);
        
        System.out.println();

        List<List<Integer>> ansList1 = new Problem040().combinationSum2(new int[]{2,5,2,1,2}, 5);
        PrintUtil.printIntListList(ansList1);
    }
    
}
