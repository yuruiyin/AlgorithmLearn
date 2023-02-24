package contest.contest329;

import java.util.Arrays;
import java.util.Comparator;

public class B {

    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[k] - o1[k];
            }
        });
        return score;
    }

}
