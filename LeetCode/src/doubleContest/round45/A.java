package doubleContest.round45;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/6
 */
public class A {


    public int sumOfUnique(int[] nums) {
        int[] countArr = new int[101];
        for (int num : nums) {
            countArr[num]++;
        }

        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if (countArr[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }

}
