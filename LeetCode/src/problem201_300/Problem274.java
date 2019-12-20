package problem201_300;

import java.util.Arrays;

public class Problem274 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        Arrays.sort(citations);
        int len = citations.length;
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (len - i <= citations[i]) {
                ans = len - i;
            }
        }
        return ans;
    }

}
