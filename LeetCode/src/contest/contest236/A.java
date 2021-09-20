package contest.contest236;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/11
 */
public class A {

    public int arraySign(int[] nums) {
        int sum = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            sum *= (num > 0 ? 1 : -1);
        }

        if (sum == 0) {
            return 0;
        } else if (sum > 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println("1");
    }

}
