package doubleContest.round126;

public class A {

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            int maxBit = 0;
            int count = 0;
            while (num > 0) {
                maxBit = Math.max(maxBit, num % 10);
                num /= 10;
                count++;
            }
            sum += Integer.parseInt((String.valueOf(maxBit)).repeat(count));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
