package contest.contest317;

public class A {

    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            if (num % 3 == 0 && num % 2 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
