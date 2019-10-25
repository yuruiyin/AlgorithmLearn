package problem001_100;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem047 {

    private void backTrack(int[] nums, boolean[] visited, List<Integer> tmpList, List<List<Integer>> ansList) {
        int n = nums.length;
        if (tmpList.size() == n) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        for (int i = 0; i < n; i++) {
            // 上一层函数被访问过的位置跳过，而且同一轮里头与上一个数是一样的也跳过
            if (visited[i] || i > 0 && !visited[i-1] && nums[i] == nums[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpList.add(nums[i]);
            backTrack(nums, visited, tmpList, ansList);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, new boolean[n], new ArrayList<>(), ansList);
        return ansList;
    }
   
    public static void main(String[] args) {
//        List<List<Integer>> ansList = new Problem047().permuteUnique(new int[]{1,1,2});
        List<List<Integer>> ansList = new Problem047().permuteUnique(new int[]{1,1,1,2});


        PrintUtil.printIntListList(ansList);
    }
    
}
