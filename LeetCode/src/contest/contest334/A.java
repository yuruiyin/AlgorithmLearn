package contest.contest334;

public class A {

    public int[] leftRigthDifference(int[] nums) {
        int len = nums.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < len; j++) {
                rightSum += nums[j];
            }
            ansArr[i] = Math.abs(leftSum - rightSum);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
