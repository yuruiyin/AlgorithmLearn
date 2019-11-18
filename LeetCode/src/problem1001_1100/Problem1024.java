package problem1001_1100;

import java.util.Arrays;
import java.util.Comparator;

public class Problem1024 {

    public int videoStitching(int[][] clips, int t) {
        int len = clips.length;
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });

        if (clips[0][0] != 0) {
            return -1;
        }

        int nextStart = clips[0][1];
        int ans = 1;
        int from = 1;
        while (true) {
            if (nextStart >= t) {
                return ans;
            }

            int maxEnd = -1;
            int maxEndIndex = -1;
            for (int i = from; i < len; i++) {
                int[] clip = clips[i];
                if (clip[0] <= nextStart && clip[1] > maxEnd) {
                    maxEnd = clip[1];
                    maxEndIndex = i;
                }

                if (clip[0] > nextStart) {
                    break;
                }
            }

            if (maxEnd == -1) {
                return -1;
            }

            ans++;
            nextStart = maxEnd;
            from = maxEndIndex + 1;
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
