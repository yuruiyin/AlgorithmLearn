package doubleContest.round18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem04 {

    class Data {
        int min;
        int max;
        Data(int min, int max){
            this.min = min;
            this.max = max;
        }
    }

    public int maxValueAfterReverse(int[] nums) {
        int sum = 0;
        int len = nums.length;

        for (int i = 0; i < len - 1; i++) {
            sum += Math.abs(nums[i] - nums[i+1]);
        }

        int ans = sum;

        Data[] datas = new Data[len];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            datas[i] = new Data(min, max);
        }

        Map<Integer, List<Integer>> indexListMap = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (indexListMap.containsKey(nums[i])) {
                indexListMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexListMap.put(nums[i], indexList);
            }
        }

        for (int i = 0; i < len - 1; i++) {
            int rightMax = datas[i+1].max;
            int rightMin = datas[i+1].min;
            List<Integer> maxIndexList = indexListMap.get(rightMax);
            for (Integer j: maxIndexList) {
                int tmpSum = sum;
                if (i == 0 && j == len - 1 || j <= i) {
                    continue;
                }
                if (j != len - 1) {
                    tmpSum -= Math.abs(nums[j] - nums[j+1]) - Math.abs(nums[i] - nums[j+1]);
                }

                if (i != 0) {
                    tmpSum -= Math.abs(nums[i] - nums[i-1]) - Math.abs(nums[j] - nums[i-1]);
                }
                ans = Math.max(tmpSum, ans);
            }

            List<Integer> minIndexList = indexListMap.get(rightMin);
            for (Integer j: minIndexList) {
                int tmpSum = sum;
                if (i == 0 && j == len - 1 || j <= i) {
                    continue;
                }
                if (j != len - 1) {
                    tmpSum -= Math.abs(nums[j] - nums[j+1]) - Math.abs(nums[i] - nums[j+1]);
                }

                if (i != 0) {
                    tmpSum -= Math.abs(nums[i] - nums[i-1]) - Math.abs(nums[j] - nums[i-1]);
                }
                ans = Math.max(tmpSum, ans);
            }
        }

        return ans;

    }
    
    public static void main(String[] args) {
        System.out.println(new Problem04().maxValueAfterReverse(new int[]{2,4,9,24,2,1,10}));
    }

}
//
//    给你一个整数数组 nums 。「 数组值」定义为所有满足 0 <= i < nums.length-1 的 |nums[i]-nums[i+1]| 的和。
//
//        你可以选择给定数组的任意子数组，并将该子数组翻转。但你只能执行这个操作 一次 。
//
//        请你找到可行的最大 数组值 。
//
//
//
//        示例 1：
//
//        输入：nums = [2,3,1,5,4]
//        输出：10
//        解释：通过翻转子数组 [3,1,5] ，数组变成 [2,5,1,3,4] ，数组值为 10 。
//        示例 2：
//
//        输入：nums = [2,4,9,24,2,1,10]
//        输出：68
//
//
//        提示：
//
//        1 <= nums.length <= 3*10^4
//        -10^5 <= nums[i] <= 10^5
