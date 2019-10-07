package doubleContest.round10;

import java.util.ArrayList;
import java.util.List;

public class Problem5079 {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] map2 = new int[2001];
        int[] map3 = new int[2001];
        List<Integer> ans = new ArrayList<>();

        for (int item: arr2) {
            map2[item] = 1;
        }

        for (int item: arr3) {
            map3[item] = 1;
        }

        for (int item: arr1) {
            if (map2[item] == 1 && map3[item] == 1) {
                ans.add(item);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

}
