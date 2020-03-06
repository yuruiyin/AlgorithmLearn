package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0804 {

    private List<List<Integer>> ansList;

    private void rec(int[] nums, int from, List<Integer> tmpList) {
        if (from == nums.length) {
            ansList.add(new ArrayList<>(tmpList));
            return;
        }

        rec(nums, from + 1, tmpList);
        tmpList.add(nums[from]);
        rec(nums, from + 1, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        ansList = new ArrayList<>();
        Arrays.sort(nums);
        ansList = new ArrayList<>();
        rec(nums, 0, new ArrayList<>());
        return ansList;
    }

}
