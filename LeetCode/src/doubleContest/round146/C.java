package doubleContest.round146;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class C {

    public boolean checkValidCuts(int n, int[][] rectangles) {
        // 先考虑坐标1和3，再考虑坐标0和2
        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] rec1, int[] rec2) {
                return rec1[1] == rec2[1] ? (rec2[3] - rec1[3]) : (rec1[1] - rec2[1]);
            }
        });

        int e = rectangles[0][3];
        int count = 1;
        for (int i = 1; i < rectangles.length; i++) {
            int curS = rectangles[i][1];
            int curE = rectangles[i][3];
            if (curS >= e) {
                count++;
                e = curE;
                if (count == 3) {
                    return true;
                }
            } else {
                e = Math.max(e, curE);
            }
        }

        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] rec1, int[] rec2) {
                return rec1[0] == rec2[0] ? (rec2[2] - rec1[2]) : (rec1[0] - rec2[0]);
            }
        });

        int e1 = rectangles[0][2];
        int count1 = 1;
        for (int i = 1; i < rectangles.length; i++) {
            int curS = rectangles[i][0];
            int curE = rectangles[i][2];
            if (curS >= e1) {
                count1++;
                e1 = curE;
                if (count1 == 3) {
                    return true;
                }
            } else {
                e1 = Math.max(e1, curE);
            }
        }

        return false;
    }

}
