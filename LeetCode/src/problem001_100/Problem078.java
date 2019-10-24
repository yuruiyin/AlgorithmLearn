package problem001_100;

import java.util.*;

public class Problem078 {

    // 递归版本
    private void backTracking(int from, int[] nums, List<Integer> tmpList, List<List<Integer>> ansList) {
        int len = nums.length;
        ansList.add(new ArrayList<>(tmpList));

        // 关键在这个from，只会从from开始往后遍历
        for (int i = from; i < len; i++) {
            tmpList.add(nums[i]);
            backTracking(i + 1, nums, tmpList, ansList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        backTracking(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem078().subsets(new int[]{1,2,3});
        
        for (List<Integer> list : ansList) {
            for (Integer num: list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }

}
