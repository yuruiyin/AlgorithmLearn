package contest.contest367;

public class C {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = -1;
        int maxIdx = -1;
        for (int i = indexDifference; i < len; i++) {
            int pre = nums[i - indexDifference];
            if (pre < min) {
                min = pre;
                minIdx = i - indexDifference;
            }
            if (pre > max) {
                max = pre;
                maxIdx = i - indexDifference;
            }
            int left = nums[i] - valueDifference;
            int right = nums[i] + valueDifference;
            if (min <= left) {
                return new int[]{minIdx, i};
            }

            if (max >= right) {
                return new int[] {maxIdx, i};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ans = new C().findIndices(new int[]{5,1,4,1}, 2, 4);
    }

}
