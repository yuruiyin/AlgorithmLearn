package doubleContest.round133;

public class A {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans += Math.min(num % 3, 3 - num % 3);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }


}
