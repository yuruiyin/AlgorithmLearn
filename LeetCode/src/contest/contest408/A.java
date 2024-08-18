package contest.contest408;

public class A {

    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int sum1 = 0;
        for (int num : nums) {
            if (num < 10) {
                sum1 += num;
            }
        }

        return sum1 * 2 != sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
