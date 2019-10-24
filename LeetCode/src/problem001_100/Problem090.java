package problem001_100;

import java.util.*;

public class Problem090 {

    private void backTracking(int from, int[] nums, List<Integer> tmpList, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(tmpList));
        int len = nums.length;

        Set<Integer> visitedSet = new HashSet<>();
        for (int i = from; i < len; i++) {
            if (visitedSet.contains(nums[i])) {
                continue;
            }

            visitedSet.add(nums[i]);
            tmpList.add(nums[i]);
            backTracking(i + 1, nums, tmpList, ansList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
//        Arrays.sort(nums);
        backTracking(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem090().subsetsWithDup(new int[]{4,1,4,4,4});

        for (List<Integer> list : ansList) {
            for (Integer num: list) {
                System.out.print(num + ",");
            }
            System.out.println();
        }
    }
    
}
