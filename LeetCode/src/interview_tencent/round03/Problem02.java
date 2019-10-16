package interview_tencent.round03;

import java.util.Arrays;
import java.util.Comparator;

public class Problem02 {

    class Data {
        int value;
        int index;
        Data(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    class CustomCmp implements Comparator<Data> {
        @Override
        public int compare(Data o1, Data o2) {
            return o1.value - o2.value;
        }
    }

    public int[] twoSum(int[] nums, int target) {
        if (nums == null) {
            return new int[]{-1, -1};
        }
        int n = nums.length;

        if (n == 0) {
            return new int[]{-1, -1};
        }

        Data[] datas = new Data[n];

        for (int i = 0; i < n; i++) {
            datas[i] = new Data(nums[i], i);
        }

        Arrays.sort(datas, new CustomCmp());

        int left = 0;
        int right = n - 1;

        while (left < right) {
            int sum = datas[left].value + datas[right].value;

            if (sum == target) {
                int leftIndex = datas[left].index;
                int rightIndex = datas[right].index;
                int minIndex;
                int maxIndex;
                if (leftIndex < rightIndex) {
                    minIndex = leftIndex;
                    maxIndex = rightIndex;
                } else {
                    minIndex = rightIndex;
                    maxIndex = leftIndex;
                }
                return new int[]{minIndex, maxIndex};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        
    }
    
}
