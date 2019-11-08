package problem1001_1100;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        int len = trips.length;
        if (trips.length == 0) {
            return true;
        }
        Arrays.sort(trips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }

                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < len; i++) {
            int[] trip = trips[i];
            int personNum = trip[0];
            int start = trip[1];

            if (personNum > capacity) {
                return false;
            }

            int count = 0;
            for (int j = 0; j < i; j++) {
                int[] tmpTrip = trips[j];
                int personNum1 = tmpTrip[0];
                int start1 = tmpTrip[1];
                int end1 = tmpTrip[2];
                if (start >= start1 && start < end1) {
                    count += personNum1;
                }

                if (count + personNum > capacity) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
    }
    
}
