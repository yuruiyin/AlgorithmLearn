package doubleContest.round145;

import utils.TreeMultiSet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class B_1 {

    private int ansMin = Integer.MAX_VALUE;

    private int size;

    private int calc(List<Integer> indexList, List<Integer> list, int k) {
        int x = 1;
        int time = 0;
        for (int idx : indexList) {
            int value = list.get(idx);
            time += value / x + (value % x == 0 ? 0 : 1);
            x += k;
        }
        return time;
    }

    private void rec(List<Integer> indexList, boolean[] indexVisited, List<Integer> list, int k) {
        if (indexList.size() == size) {
            ansMin = Math.min(ansMin, calc(indexList, list, k));
            return;
        }

        for (int i = 0; i < size; i++) {
            if (indexVisited[i]) {
                continue;
            }
            indexVisited[i] = true;
            indexList.add(i);
            rec(indexList, indexVisited, list, k);
            indexList.remove(indexList.size() - 1);
            indexVisited[i] = false;
        }
    }

    public int findMinimumTime(List<Integer> list, int k) {
        this.size = list.size();
        rec(new ArrayList<>(), new boolean[size], list, k);
        return ansMin;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(new B_1().findMinimumTime(list, 1));
    }

}
