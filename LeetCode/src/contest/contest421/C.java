package contest.contest421;

import javax.print.DocFlavor;
import java.util.*;

public class C {

    private static final int MOD = (int) 1e9 + 7;

    private List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (i != num / i) {
                    list.add(num / i);
                }
            }
        }

        return list;
    }

    public int subsequencePairCount(int[] nums) {
        //  todo
        return 0;
    }

}
