package contest.contest203;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/23
 */
public class A {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int len = rounds.length;
        int[] countArr = new int[n + 1];
        countArr[rounds[0]]++;
        for (int i = 0; i < len - 1; i++) {
            int from = rounds[i];
            int to = rounds[i + 1];
            for (int j = from % n + 1; ;j = (j % n) + 1) {
                countArr[j]++;
                if (j == to) {
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, countArr[i]);
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (countArr[i] == max) {
                ansList.add(i);
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        System.out.println(new A().mostVisited(4, new int[]{1,3,1,2}));
    }

}
