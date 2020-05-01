package doubleContest.round24;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class A {

    public int minStartValue(int[] nums) {
        for (int i = 1; i <= 20000; i++) {
            int sum = i;
            boolean isOk = true;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (sum < 1) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return i;
            }
        }

        return -1;
    }

}
