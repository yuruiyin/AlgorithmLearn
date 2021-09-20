package fall_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/11
 */
public class B {

    public int maxmiumScore(int[] cards, int cnt) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int num : cards) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }

        Collections.sort(oddList);
        Collections.sort(evenList);

        int ans = 0;
        int[] suffixSumOddArr = new int[oddList.size()];
        if (oddList.size() > 0) {
            suffixSumOddArr[oddList.size() - 1] = oddList.get(oddList.size() - 1);
            for (int i = oddList.size() - 2; i >= 0; i--) {
                suffixSumOddArr[i] = suffixSumOddArr[i + 1] + oddList.get(i);
            }
        }

        int[] suffixSumEvenArr = new int[evenList.size()];
        if (evenList.size() > 0) {
            suffixSumEvenArr[evenList.size() - 1] = evenList.get(evenList.size() - 1);
            for (int i = evenList.size() - 2; i >= 0; i--) {
                suffixSumEvenArr[i] = suffixSumEvenArr[i + 1] + evenList.get(i);
            }
        }

        for (int oddCount = 0; oddCount <= cnt; oddCount += 2) {
            int evenCount = cnt - oddCount;
            if (oddCount > oddList.size() || evenCount > evenList.size()) {
                continue;
            }
            int value = 0;
            if (oddCount > 0) {
                value += suffixSumOddArr[oddList.size() - oddCount];
            }

            if (evenCount > 0) {
                value += suffixSumEvenArr[evenList.size() - evenCount];
            }

            ans = Math.max(ans, value);
        }

        return ans;
    }

}
