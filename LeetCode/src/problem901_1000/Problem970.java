package problem901_1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> ansList = new ArrayList<>();
        if (x == 1 && y == 1) {
            if (bound >= 2) {
                ansList.add(2);
            }
            return ansList;
        }

        Set<Integer> set = new HashSet<>();
        if (x == 1) {
            for (int i = 0; ;i++) {
                int num = (int) (Math.pow(y, i) + 1);
                if (num > bound) {
                    break;
                }
                set.add(num);
            }
            return new ArrayList<>(set);
        }

        if (y == 1) {
            for (int i = 0; ;i++) {
                int num = (int) (Math.pow(x, i) + 1);
                if (num > bound) {
                    break;
                }
                set.add(num);
            }
            return new ArrayList<>(set);
        }

        for (int i = 0; ;i++) {
            if (Math.pow(x, i) + 1 > bound) {
                break;
            }

            for (int j = 0; ;j++) {
                int num = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (num > bound) {
                    break;
                }
                set.add(num);
            }
        }

        return new ArrayList<>(set);
    }

}
