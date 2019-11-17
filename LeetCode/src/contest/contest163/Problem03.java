package contest.contest163;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem03 {

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        List<Integer>[] indexList = new ArrayList[3];

        for (int i = 1; i <= 2; i++) {
            indexList[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            if (num % 3 == 0) {
                continue;
            }
            indexList[num % 3].add(i);
        }

        int value = sum % 3;
        if (value == 0) {
            return sum;
        }

        int min = Integer.MAX_VALUE;
        if (!indexList[value].isEmpty()) {
            min = nums[indexList[value].get(0)];
        }

        int nextValue = value == 1 ? 2 : 1;

        if (indexList[nextValue].size() >= 2) {
            int sum1 = nums[indexList[nextValue].get(0)] + nums[indexList[nextValue].get(1)];
            if (sum1 < min) {
                min = sum1;
            }
        }

        return  sum - min;
    }
    
    public static void main(String[] args) {
        
    }
    
}
