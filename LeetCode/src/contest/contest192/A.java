package contest.contest192;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/7
 */
public class A {

    public int[] shuffle(int[] nums, int n) {
        int[] ansArr = new int[2 * n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            ansArr[count++] = nums[i];
            ansArr[count++] = nums[i + n];
        }

        return ansArr;
    }

}
