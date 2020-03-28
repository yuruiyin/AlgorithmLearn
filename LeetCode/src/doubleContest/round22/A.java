package doubleContest.round22;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class A {

    private int getCount(int num1, int[] arr2, int d) {
        for (int num2 : arr2) {
            if (Math.abs(num1 - num2) <= d) {
                return 0;
            }
        }
        return 1;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int num1 : arr1) {
            ans += getCount(num1, arr2, d);
        }
        return ans;
    }

}
