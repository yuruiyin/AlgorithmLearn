package contest.contest249;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/11
 */
public class A {

    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ansArr = new int[len * 2];
        for (int i = 0; i < len; i++) {
            ansArr[i] = nums[i];
        }

        for (int i = len; i < 2 * len; i++) {
            ansArr[i] = nums[i - len];
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
