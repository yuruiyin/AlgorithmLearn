package contest.contest427;

public class A {

    public int[] constructTransformedArray(int[] nums) {
        int len = nums.length;
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                ansArr[i] = nums[(i + nums[i]) % len];
            } else if (nums[i] < 0) {
                ansArr[i] = nums[(i + 100 * len + nums[i]) % len];
            } else {
                ansArr[i] = nums[i];
            }
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
