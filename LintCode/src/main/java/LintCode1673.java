import java.util.HashMap;
import java.util.Map;

/**
 * LintCode1673
 *
 * @author: yry
 * @date: 2020/3/18
 */
public class LintCode1673 {

    public int[] getAns(int[] op, String[] name, int[] w) {
        int len = op.length;
        if (len == 0) {
            return new int[0];
        }

        Map<String, Integer> map = new HashMap<>();
        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int curW = map.getOrDefault(name[i], 0);
            if (op[i] == 0) {
                map.put(name[i], curW + w[i]);
                ansArr[i] = curW + w[i];
            } else {
                if (curW < w[i]) {
                    ansArr[i] = -1;
                } else {
                    map.put(name[i], curW - w[i]);
                    ansArr[i] = curW - w[i];
                }
            }
        }

        return ansArr;
    }

}
