package doubleContest.round086;

public class A {

    public boolean findSubarrays(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int sum1 = nums[i] + nums[i + 1];
            for (int j = i + 1; j < len - 1; j++) {
                int sum2 = nums[j] + nums[j + 1];
                if (sum1 == sum2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
