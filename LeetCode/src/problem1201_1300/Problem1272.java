package problem1201_1300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1272 {

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> ansList = new ArrayList<>();

        int start = toBeRemoved[0];
        int end = toBeRemoved[1];

        for (int[] interval: intervals) {
            if (start >= interval[1]) {
                ansList.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
            } else if (start > interval[0]) {
                ansList.add(new ArrayList<>(Arrays.asList(interval[0], start)));
            }

            if (end < interval[0]) {
                ansList.add(new ArrayList<>(Arrays.asList(interval[0], interval[1])));
            } else if (end < interval[1]) {
                ansList.add(new ArrayList<>(Arrays.asList(end, interval[1])));
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        
    }
    
}
