package doubleContest.round22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class C {

    class Data {
        int val;
        int w;
        Data(int val, int w) {
            this.val = val;
            this.w = w;
        }
    }

    private int getWeight(int num) {
        int count = 0;
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
            count++;
        }

        return count;
    }

    public int getKth(int lo, int hi, int k) {
        List<Data> list = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            list.add(new Data(i, getWeight(i)));
        }

        list.sort((o1, o2) -> o1.w == o2.w ? o1.val - o2.val : o1.w - o2.w);
        return list.get(k - 1).val;
    }

}
