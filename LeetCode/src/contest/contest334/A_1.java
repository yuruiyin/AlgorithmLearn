package contest.contest334;

public class A_1 {

    public int[] leftRigthDifference(int[] nums) {
        int len = nums.length;

        int[] ansArr = new int[len];
        int[] preSumArr = new int[len];
        preSumArr[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSumArr[i] = preSumArr[i - 1] + nums[i];
        }
        ansArr[0] = preSumArr[len - 1] - preSumArr[0];
        for (int i = 1; i < len; i++) {
            ansArr[i] = Math.abs(preSumArr[i - 1] - preSumArr[len - 1] + preSumArr[i]);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
