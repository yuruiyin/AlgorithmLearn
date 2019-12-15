package doubleContest.round15;

import java.util.List;

public class Problem02 {

    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        int ans = len;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                    ans--;
                    break;
                }
            }
        }

        return ans;
    }
   
    public static void main(String[] args) {
        
    }
    
}
