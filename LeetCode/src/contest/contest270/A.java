package contest.contest270;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * a
 *
 * @author: yry
 * @date: 2021/12/5
 */
public class A {

    public int[] findEvenNumbers(int[] digits) {
        int len = digits.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (digits[i] == 0 || i == j || i == k || j == k) {
                        continue;
                    }
                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (num % 2 == 0) {
                        set.add(num);
                    }
                }
            }
        }

        int size = set.size();
        int[] ansArr = new int[size];
        int i = 0;
        for (int num : set) {
            ansArr[i++] = num;
        }
        Arrays.sort(ansArr);
        return ansArr;
    }

}
