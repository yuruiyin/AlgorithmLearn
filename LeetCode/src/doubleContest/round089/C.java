package doubleContest.round089;

public class C {

    public int minimizeArrayValue(int[] nums) {
        int ansMax = nums[0];
        int len = nums.length;
        int count = 1;
        long sum = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                int aver = (int) (sum / count);
                int mod = (int) (sum / count);
                if (mod != 0) {
                    aver++;
                }
                ansMax = Math.max(ansMax, aver);
                if (mod != 0) {

                }
                sum = nums[i];
                count = 1;
                continue;
            }
            count++;
            sum += nums[i];
        }
        int aver = (int) (sum / count);
        if (sum % count != 0) {
            aver++;
        }
        ansMax = Math.max(ansMax, aver);
        return ansMax;
    }

}
