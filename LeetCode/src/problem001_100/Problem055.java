package problem001_100;

public class Problem055 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        for (int i = 0; i < n - 1;) {
            if (i == n - 2) {
                return nums[i] > 0;
            }

            if (nums[i] >= n - i) {
                return true;
            }

            if (nums[i] == 0) {
                return false;
            }

            int max = 0;
            int maxIndex = i + 1;

            int maxJ = i + nums[i];
            for (int j = i + 1; j <= maxJ; j++) {
                int indexValueSum = nums[j] + j;
                if (indexValueSum > max) {
                    max = indexValueSum;
                    maxIndex = j;
                }
            }

            i = maxIndex;
        }

        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem055().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Problem055().canJump(new int[]{3,2,1,0,4}));
    }
    
}
