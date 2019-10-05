package interview_toutiao.round01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem02 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int minLen = Integer.MAX_VALUE;
        int[] resInterval = new int[2];
        int size = nums.size();
        int[] firstIndex = new int[size];

        while (true) {
            // 找出最大和最小
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;
            int minIndex = -1;
            for (int i = 0; i < size; i++) {
                int firstValue = nums.get(i).get(firstIndex[i]);
                if (firstValue < minValue) {
                    minValue = firstValue;
                    minIndex = i;
                }

                if (firstValue > maxValue) {
                    maxValue = firstValue;
                }
            }

            int len = maxValue - minValue;
            if (len < minLen) {
                minLen = len;
                resInterval[0] = minValue;
                resInterval[1] = maxValue;
            }

            if (firstIndex[minIndex] == nums.get(minIndex).size() - 1) {
                break;
            }
            firstIndex[minIndex]++;
        }

        return resInterval;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(4);
        list1.add(10);
        list1.add(15);
        list1.add(24);
        list1.add(26);

        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(9);
        list2.add(12);
        list2.add(20);

        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(18);
        list3.add(22);
        list3.add(30);

        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);

        int[] resArr = new Problem02().smallestRange(list);

        for (int item : resArr) {
            System.out.print(item + " ");
        }
    }
}
