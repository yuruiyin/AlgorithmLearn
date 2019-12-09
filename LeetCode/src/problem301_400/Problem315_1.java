package problem301_400;

import java.util.ArrayList;
import java.util.List;

public class Problem315_1 {

    private int findLastSmaller(List<Integer> numList, int target) {
        int low = 0;
        int size = numList.size();
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = numList.get(mid);

            if (midVal < target) {
                if (mid == size - 1 || target <= numList.get(mid + 1)) {
                    // 找到最后一个比他小的
                    return mid;
                }

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> numList = new ArrayList<>();
        int[] ansArr = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            int lastSmallerIndex = findLastSmaller(numList, nums[i]);
            ansArr[i] = lastSmallerIndex + 1;
            // 虽然这里看起来时间复杂度也是O(n*n)，但是java的list的add方法使用到了System.arrayCopy方法，而这个方法是一个native方法，jvm那一层有做了加速
            numList.add(ansArr[i], nums[i]);
        }

        List<Integer> ansList = new ArrayList<>();

        for (int num: ansArr) {
            ansList.add(num);
        }

        return ansList;
    }

}
