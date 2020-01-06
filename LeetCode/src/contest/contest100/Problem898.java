package contest.contest100;

import java.util.HashSet;
import java.util.Set;

public class Problem898 {

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> cur = new HashSet<>();
        Set<Integer> ansSet = new HashSet<>();

        for (int num : arr) {
            Set<Integer> tmpCur = new HashSet<>();
            for (Integer tmp: cur) {
                tmpCur.add(num | tmp);
            }
            tmpCur.add(num);
            cur = tmpCur;
            ansSet.addAll(cur);
        }

        return ansSet.size();
    }

}
