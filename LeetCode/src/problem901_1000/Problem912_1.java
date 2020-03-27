package problem901_1000;

import sort.MergeSort;

/**
 * 列出所有的排序算法
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class Problem912_1 {

    public int[] sortArray(int[] nums) {
        MergeSort.mergeSort(nums);
        return nums;
    }

}
