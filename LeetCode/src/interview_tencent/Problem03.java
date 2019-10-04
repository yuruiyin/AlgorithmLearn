package interview_tencent;

import java.util.HashSet;
import java.util.Set;

public class Problem03 {

    public int singleNumber(int[] nums) {
        long sum = 0;
        long setSum = 0;
        int n = nums.length;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            sum += num;
        }

        for (int num : nums) {
            set.add(num);
        }

        for (int num: set) {
            setSum += num;
        }

        return (int) ((3 * setSum - sum) / 2);
    }

    public int singleNumber1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 2};
//        int[] arr = new int[]{0, 1, 0, 1, 0, 1, 99};
//        int[] arr = new int[]{-19,-46,-19,-46,-9,-9,-19,17,17,17,-13,-13,-9,-13,-46,-28};
        System.out.println(new Problem03().singleNumber(arr));
        System.out.println(new Problem03().singleNumber1(arr));
    }

}
