package contest.contest374;

import java.util.ArrayList;
import java.util.List;

public class D {

    public int numberOfSequence(int n, int[] sick) {
        // [0, n - 1]
        int len = sick.length;
        int left = 0;
        int start = sick[0] == 0 ? 0 : sick[0];
        int end = sick[len - 1] == n - 1 ? 0 : n - 1 - sick[len - 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < len; i++) {
            int count = sick[i] - left;
            if (count > 0) {
                list.add(count);
            }
            left = sick[i] + 1;
        }

        int size = list.size();
        if (size == 0) {
            // 中间没有，只有两边
            if (start == 0 || end == 0) {
                return 1;
            }

        }

        List<Integer> countList = new ArrayList<>();

        for (int i = 1; i < size - 1; i++) {

        }

        countList.add(list.get(size - 1));

        return 0;
    }

}
