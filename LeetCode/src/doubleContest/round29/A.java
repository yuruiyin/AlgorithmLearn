package doubleContest.round29;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/27
 */
public class A {

    public double average(int[] salary) {
        Arrays.sort(salary);
        int len = salary.length;
        double sum = 0;

        for (int i = 1; i < len - 1; i++) {
            sum += salary[i];
        }

        return sum / (len - 2);
    }

}
