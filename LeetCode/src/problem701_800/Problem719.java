package problem701_800;

public class Problem719 {

    public int smallestDistancePair(int[] nums, int k) {
        int len = nums.length;
        int N = 1000001;
        int[] countArr = new int[N];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int abs = Math.abs(nums[i] - nums[j]);
                countArr[abs]++;
            }
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            count += countArr[i];
            if (count >= k) {
                return i;
            }
        }
        return 0;
    }

}
