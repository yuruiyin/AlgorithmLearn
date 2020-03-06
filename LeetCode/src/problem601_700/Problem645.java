package problem601_700;

public class Problem645 {

    public int[] findErrorNums(int[] nums) {
        int[] ansArr = new int[2];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (num - 1 != i) {
                int nextNum = nums[num - 1];
                if (nextNum == num) {
                    ansArr[0] = num;
                    break;
                } else {
                    nums[num - 1] = num;
                    nums[i] = nextNum;
                    num = nums[i];
                }
            }
        }

        for (int i = 0; i < len; i++) {
            if (i != nums[i] - 1) {
                ansArr[1] = i + 1;
                break;
            }
        }

        return ansArr;
    }

}
