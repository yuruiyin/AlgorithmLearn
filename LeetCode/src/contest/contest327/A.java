package contest.contest327;

public class A {

    public int maximumCount(int[] nums) {
        int posCount = 0;
        int nagCount = 0;
        for (int num : nums) {
            if (num < 0) {
                nagCount++;
            } else if (num > 0) {
                posCount++;
            }
        }
        return Math.max(nagCount, posCount);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
