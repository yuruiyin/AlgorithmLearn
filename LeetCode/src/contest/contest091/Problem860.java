package contest.contest091;

public class Problem860 {

    public boolean lemonadeChange(int[] bills) {
        int[] countArr = new int[21];
        int len = bills.length;
        for (int i = 0; i < len; i++) {
            countArr[bills[i]]++;
            if (bills[i] == 5) {
                continue;
            }

            int diff = bills[i] - 5;
            if (diff == 5) {
                if (countArr[5] == 0) {
                    return false;
                }
                countArr[5]--;
            } else {
                // diff = 15
                if (countArr[10] > 0 && countArr[5] > 0) {
                    countArr[10]--;
                    countArr[5]--;
                } else if (countArr[10] == 0 && countArr[5] >=3) {
                    countArr[5] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

}
