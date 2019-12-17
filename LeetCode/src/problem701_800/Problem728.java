package problem701_800;

import java.util.ArrayList;
import java.util.List;

public class Problem728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int num = i;
            boolean isMatch = true;
            while (num > 0) {
                int lowBit = num % 10;
                if (lowBit == 0 || i % lowBit != 0) {
                    isMatch = false;
                    break;
                }
                num /= 10;
            }

            if (isMatch) {
                ansList.add(i);
            }
        }

        return ansList;
    }

}
