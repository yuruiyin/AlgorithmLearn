import java.util.TreeSet;

/**
 * LintCode1690
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode1690 {

    public int[] getAns(int[] val) {
        if (val == null || val.length == 0) {
            return new int[0];
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(val[0]);
        int len = val.length;
        int[] ansArr = new int[len - 1];
        for (int i = 1; i < len; i++) {
            if (treeSet.contains(val[i])) {
                ansArr[i - 1] = val[i];
            } else {
                Integer lower = treeSet.lower(val[i]);
                Integer higher = treeSet.higher(val[i]);
                if (lower == null) {
                    ansArr[i - 1] = higher;
                } else if (higher == null) {
                    ansArr[i - 1] = lower;
                } else {
                    if (val[i] - lower <= higher - val[i]) {
                        ansArr[i - 1] = lower;
                    } else  {
                        ansArr[i - 1] = higher;
                    }
                }

                treeSet.add(val[i]);
            }
        }

        return ansArr;
    }

}
