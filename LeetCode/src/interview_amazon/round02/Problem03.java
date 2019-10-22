package interview_amazon.round02;

public class Problem03 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;

        if (k == 1) {
            return nums;
        }

        int[] ansArr = new int[n - k + 1];
        int count = 0;
        int lastMaxIndex = -1;
        int lastSecondMaxIndex = -1;

        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= maxNum) {
                maxNum = nums[i];
                lastMaxIndex = i;
            }
        }

        ansArr[count++] = maxNum;
        int secondMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (i == lastMaxIndex) {
                continue;
            }
            if (nums[i] >= secondMaxNum) {
                secondMaxNum = nums[i];
                lastSecondMaxIndex = i;
            }
        }

        for (int i = k; i < n; i++) {
            if (lastMaxIndex <= i - k) {
                if (nums[i] > nums[lastSecondMaxIndex]) {
                    ansArr[count++] = nums[i];
                    lastMaxIndex = i;
                } else {
                    ansArr[count++] = nums[lastSecondMaxIndex];
                    lastMaxIndex = lastSecondMaxIndex;
                }
            }
        }

        return new int[0];

    }
    
    public static void main(String[] args) {
        
    }
    
}
