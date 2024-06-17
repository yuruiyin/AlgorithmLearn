package contest.contest402;

import utils.FenwickTree;

import java.util.ArrayList;
import java.util.List;

public class D {

    private void update(FenwickTree f, int[] nums, int i, int val) {
        if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
            f.update(i, val);
        }
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int len = nums.length;
        FenwickTree fenwickTree = new FenwickTree(len);
        for (int i = 1; i < len - 1; i++) {
            update(fenwickTree, nums, i, 1);
        }

        List<Integer> ansList = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                ansList.add(fenwickTree.rangeQuery(q[1] + 1, q[2] - 1));
                continue;
            }

            int i = q[1];
            int start = Math.max(i - 1, 1);
            int end = Math.min(i + 1, len - 2);
            for (int j = start; j <= end; j++) {
                update(fenwickTree, nums, j, -1);
            }

            nums[i] = q[2];
            for (int j = start; j <= end; j++) {
                update(fenwickTree, nums, j, 1);
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
//        List<Integer> ansList = new D().countOfPeaks(new int[]{
//                4, 1, 4, 2, 1, 5
//        }, new int[][]{
//                {2, 2, 4}, {1, 0, 2}, {1, 0, 4}
//        });
        List<Integer> ansList = new D().countOfPeaks(new int[]{
                4, 6, 9, 3, 5
        }, new int[][]{
                {2, 1, 9}, {2, 1, 6}, {2, 2, 4}, {1, 1, 3}
        });
        for (int num : ansList) {
            System.out.println(num);
        }
    }

}
