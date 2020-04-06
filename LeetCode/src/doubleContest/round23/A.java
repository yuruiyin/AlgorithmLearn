package doubleContest.round23;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/4
 */
public class A {

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int countLargestGroup(int n) {
        int[] countArr = new int[100];
        for (int i = 1; i <= n; i++) {
            countArr[getSum(i)]++;
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, countArr[i]);
        }

        int ans = 0;
        for (int i = 0; i < 100; i++) {
            if (countArr[i] == max) {
                ans++;
            }
        }

        return ans;
    }

}
