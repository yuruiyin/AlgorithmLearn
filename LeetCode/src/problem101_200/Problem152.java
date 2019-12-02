package problem101_200;

public class Problem152 {

    public int maxProduct(int[] nums) {
        int ansMax = nums[0];
        int prevPositiveMax = Math.max(nums[0], 1);
        int prevNegativeMin = Math.min(nums[0], 1);
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            int num = nums[i];
            if (num == 0) {
                prevPositiveMax = 0;
                prevNegativeMin = 0;
            } else if (num > 0) {
                if (prevPositiveMax > 0) {
                    prevPositiveMax *= num;
                } else {
                    prevPositiveMax = num;
                }

                if (prevNegativeMin < 0) {
                    prevNegativeMin *= num;
                }
            } else {
                int oldPrevNegativeMin = prevNegativeMin;
                if (prevPositiveMax > 0) {
                    prevNegativeMin = num * prevPositiveMax;
                } else {
                    prevNegativeMin = num;
                }

                if (oldPrevNegativeMin < 0) {
                    prevPositiveMax = oldPrevNegativeMin * num;
                } else {
                    prevPositiveMax = 0;
                }
            }

            if (prevPositiveMax > ansMax) {
                ansMax = prevPositiveMax;
            }
        }

        return ansMax;
    }

    public static void main(String[] args) {
        System.out.println(new Problem152().maxProduct(new int[]{-4, -3}));
    }
}
