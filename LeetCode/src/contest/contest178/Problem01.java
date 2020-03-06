package contest.contest178;

public class Problem01 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] ansArr = new int[len];

        for (int i = 0; i < len; i++) {
            int cnt = 0;
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    if (nums[j] < nums[i]) {
                        cnt++;
                    }
                }
            }

            ansArr[i] = cnt;
        }

        return ansArr;
    }

}
