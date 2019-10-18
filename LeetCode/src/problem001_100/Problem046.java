package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem046 {

    private List<List<Integer>> ansList = new ArrayList<>();

    /**
     * 回溯法
     * @param ansList 目标list
     * @param nums 原始要被全排列的数组
     * @param tmp 临时list，用于存放一个排列中的每个元素
     * @param visited 标记元素是否被访问过
     */
    private void backTrack(List<List<Integer>> ansList, int[] nums, List<Integer> tmp, boolean[] visited) {
        if (tmp.size() == nums.length) {
            // 遍历到叶子节点,最后一个元素
            ansList.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            tmp.add(nums[i]);
            backTrack(ansList, nums, tmp, visited);
            visited[i] = false;
            tmp.remove(tmp.size() - 1);  // 这里不能用tmp.remove(nums[i]),因为nums是整数，调用remove函数删除元素，会误认为删除指定index的元素。
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ansList = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] visited = new boolean[len];
        backTrack(ansList, nums, tmp, visited);
        return ansList;
    }

    public static void main(String[] args) {
        List<List<Integer>> ansList = new Problem046().permute(new int[]{1, 2, 3});
        
        for (List<Integer> list : ansList) {
            for (Integer item: list) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }

}
