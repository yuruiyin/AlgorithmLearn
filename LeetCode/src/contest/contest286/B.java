package contest.contest286;

public class B {

    public int minDeletion(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }

        int ansMin = len;
        int count = 0;
        int preNum = nums[0];
        for (int i = 1; i < len; i++) {
            if ((i - count) % 2 == 1 && nums[i] == preNum) {
                count++;
                preNum = nums[i - 1];
            } else {
                preNum = nums[i];
            }
        }
        if ((len - count) % 2 == 1) {
            count++;
        }
        ansMin = count;

        if (nums[0] != nums[1]) {
            return ansMin;
        }

        count = 1;
        preNum = nums[1];
        for (int i = 2; i < len; i++) {
            if ((i - count) % 2 == 1 && nums[i] == preNum) {
                count++;
                preNum = nums[i - 1];
            } else {
                preNum = nums[i];
            }
        }
        if ((len - count) % 2 == 1) {
            count++;
        }
        ansMin = Math.min(ansMin, count);
        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println(new B().minDeletion(new int[]{2,8,1,2,1,0,5,1,8}));

        System.out.println("hello");
    }
    
}
