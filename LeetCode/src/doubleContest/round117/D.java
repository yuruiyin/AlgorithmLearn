package doubleContest.round117;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D {

    public long maxSpending(int[][] values) {
        List<Integer> list = new ArrayList<>();
        int m = values.length;
        int n = values[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(values[i][j]);
            }
        }
        Collections.sort(list);
        long ans = 0;
        for (int i = 0; i < m * n; i++) {
            ans += (i + 1L) * list.get(i);
        }
        return ans;
    }

}
