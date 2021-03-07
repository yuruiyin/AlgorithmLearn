package doubleContest.round41;

import java.util.Arrays;
import java.util.Comparator;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/12
 */
public class C {

    class Data {
        int alice;
        int bob;
        Data(int alice, int bob) {
            this.alice = alice;
            this.bob = bob;
        }
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int len = aliceValues.length;
        Data[] sumArr = new Data[len];
        for (int i = 0; i < len; i++) {
            sumArr[i] = new Data(aliceValues[i], bobValues[i]);
        }

        Arrays.sort(sumArr, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.alice + o2.bob - (o1.alice + o1.bob);
            }
        });

        int aliceSum = 0;
        int bobSum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                aliceSum += sumArr[i].alice;
            } else {
                bobSum += sumArr[i].bob;
            }
        }

        return aliceSum > bobSum ? 1 : (aliceSum == bobSum ? 0 : -1);
    }

}
