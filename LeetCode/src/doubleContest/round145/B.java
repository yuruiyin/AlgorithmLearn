package doubleContest.round145;

import utils.TreeMultiSet;

import java.util.*;

public class B {

    public int findMinimumTime(List<Integer> list, int k) {
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        treeMultiSet.addAll(list);
        int power = 0;
        int time = 0;
        int x = 1;

        while (!treeMultiSet.isEmpty()) {
            // 求 <= power 的最大元素
            while (true) {
                Integer floor = treeMultiSet.floor(power);
                if (floor == null) {
                    power += x;
                    time++;
                } else {
                    power = 0;
                    x += k;
                    treeMultiSet.remove(floor);
                    break;
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        System.out.println(new B().findMinimumTime(list, 1));
    }

}
