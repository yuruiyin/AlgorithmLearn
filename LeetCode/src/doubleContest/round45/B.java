package doubleContest.round45;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/6
 */
public class B {

    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int sum = nums[0];
        int ansMax = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            ansMax = Math.max(ansMax, Math.abs(sum - min));
            ansMax = Math.max(ansMax, Math.abs(sum - max));
            ansMax = Math.max(ansMax, Math.abs(sum));
            min = Math.min(sum, min);
            max = Math.max(sum, max);
        }

        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new B().maxAbsoluteSum(new int[]{2,-5,1,-4,3,-2}));
        System.out.println(new B().maxAbsoluteSum(new int[]{1}));
        System.out.println(new B().maxAbsoluteSum(new int[]{1,2}));
        System.out.println(new B().maxAbsoluteSum(new int[]{-1,-2}));
    }

}
