package contest.contest328;

public class A {

    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int sum1 = 0;
        for (int num : nums) {
            sum += num;
            while (num > 0) {
                sum1 += num % 10;
                num /= 10;
            }
        }

        return Math.abs(sum - sum1);

    }

    public static void main(String[] args) {
        System.out.println("hello wold");
    }

}
