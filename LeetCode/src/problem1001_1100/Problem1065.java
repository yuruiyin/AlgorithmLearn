package problem1001_1100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Problem1065 {

    public int[][] indexPairs(String text, String[] words) {
        List<List<Integer>> ansList = new ArrayList<>();

        for (String word: words) {
            for (int i = 0; i < text.length();) {
                int index = text.indexOf(word, i);
                if (index == -1) {
                    break;
                }

                ansList.add(new ArrayList<>(Arrays.asList(index, index + word.length() - 1)));
                i = index + 1;
            }
        }

        int[][] ansArr = new int[ansList.size()][2];

        for (int i = 0; i < ansList.size(); i++) {
            ansArr[i][0] = ansList.get(i).get(0);
            ansArr[i][1] = ansList.get(i).get(1);
        }

        Arrays.sort(ansArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0]- o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        return ansArr;
    }
    
    public static void main(String[] args) {
        int[][] ans = new Problem1065().indexPairs("ababa", new String[]{"aba", "ab"});

        for (int[] arr : ans) {

        }
    }
    
}
