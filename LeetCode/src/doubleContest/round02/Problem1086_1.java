package doubleContest.round02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1086_1 {

    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }

                return o2[1] - o1[1];
            }
        });

        int len = items.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len;) {
            int sum = 0;
            for (int j = i; j < i + 5; j++) {
                sum += items[j][1];
            }
            List<Integer> aver = new ArrayList<>();
            aver.add(items[i][0]);
            aver.add(sum / 5);

            list.add(aver);

            int oldId = items[i][0];

            while (i < len && items[i][0] == oldId) {
                i++;
            }
        }

        int[][] ans = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
