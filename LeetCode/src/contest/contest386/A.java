package contest.contest386;

public class A {

    public boolean isPossibleToSplit(int[] nums) {
        int[] countArr = new int[101];
        for (int num : nums) {
            countArr[num]++;
        }

        for (int i = 0; i <= 100; i++) {
            if (countArr[i] > 2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
