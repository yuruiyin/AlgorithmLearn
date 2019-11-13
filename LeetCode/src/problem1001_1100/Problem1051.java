package problem1001_1100;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1051 {

    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] originHeights = Arrays.copyOf(heights, len);
        Set<Integer>[] indexSet = new HashSet[101];
        Arrays.sort(heights);

        for (int i = 0; i < len; i++) {
            int num = heights[i];
            if (indexSet[num] == null) {
                indexSet[num]= new HashSet<>();
            }
            indexSet[num].add(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            int num = originHeights[i];
            if (!indexSet[num].contains(i)) {
                ans++;
            }
        }

        return ans;

    }
    
    public static void main(String[] args) {

    }
    
}
