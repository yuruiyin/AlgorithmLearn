package doubleContest.round76;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class C {

    class ATM {

        // 20 ，50 ，100 ，200 和 500 美元
        private long[] countArr;
        private int[] map;


        public ATM() {
            countArr = new long[5];
            map = new int[5];
            map[0] = 20;
            map[1] = 50;
            map[2] = 100;
            map[3] = 200;
            map[4] = 500;
        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < 5; i++) {
                countArr[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            long[] oldCountArr = Arrays.copyOf(countArr, countArr.length);
            int[] ansArr = new int[5];
            for (int i = 4; i >= 0; i--) {
                if (countArr[i] != 0) {
                    int count = amount / map[i];
                    if (count == 0) {
                        continue;
                    }

                    if (count >= countArr[i]) {
                        amount -= countArr[i] * map[i];
                        ansArr[i] = (int) countArr[i];
                        countArr[i] = 0;
                    } else {
                        amount -= count * map[i];
                        ansArr[i] = count;
                        countArr[i] -= count;
                    }
                }
                if (amount == 0) {
                    return ansArr;
                }
            }
            countArr = oldCountArr;
            return new int[]{-1};
        }
    }

}
