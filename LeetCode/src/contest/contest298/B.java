package contest.contest298;

import java.util.ArrayList;
import java.util.List;

public class B {

    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }

        int minBit = num % 10;
        int count = -1;
        for (int i = 1; i <= 10 && i * k <= num; i++) {
            if ((k * i) % 10 == minBit) {
                count = i;
                break;
            }
        }
        return count;
    }

}
