package problem301_400;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem386_1
 *
 * @author: yry
 * @date: 2020/4/8
 */
public class Problem386_1 {

    private void dfs(int cur, int n, List<Integer> list) {
        if (cur > n) {
            return;
        }

        list.add(cur);
        cur *= 10;

        for (int i = 0; i <= 9; i++) {
            if (cur + i > n) {
                return;
            }

            dfs(cur + i, n, list);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, ansList);
        }
        return ansList;
    }

}
