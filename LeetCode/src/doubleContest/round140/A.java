package doubleContest.round140;

public class A {

    public int minElement(int[] nums) {
        int ansMin = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                int bit = num % 10;
                num /= 10;
                sum += bit;
            }
            ansMin = Math.min(ansMin, sum);
        }
        return ansMin;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
