package contest.contest188;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/10
 */
public class A {

    public List<String> buildArray(int[] target, int n) {
        int len = target.length;
        List<String> ansList = new ArrayList<>();
        int cur = 1;
        for (int i = 0; i < len; i++) {
            int num = target[i];
            if (cur == num) {
                ansList.add("Push");
            } else {
                while (cur < num) {
                    ansList.add("Push");
                    ansList.add("Pop");
                    cur++;
                }
                ansList.add("Push");
            }
            cur++;
        }

        return ansList;
    }

}
