package spring_2023_personal;

import java.util.ArrayList;
import java.util.List;

public class A {

    public int[] supplyWagon(int[] supplies) {
        int len = supplies.length;
        List<Integer> list = new ArrayList<>();
        for (int num : supplies) {
            list.add(num);
        }
        while (list.size() > len / 2) {
            int size = list.size();
            int minSum = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i = 0; i < size - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    minIdx = i;
                }
            }
            list.remove(minIdx);
            list.remove(minIdx);
            list.add(minIdx, minSum);
        }
        int[] ansArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ansArr[i] = list.get(i);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
