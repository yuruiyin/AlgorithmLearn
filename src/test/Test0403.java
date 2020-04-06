package test;

import java.util.*;

/**
 * Test0403
 * 就是一个数组，里面的数比前面的都大叫正序数，问随机删除一个数，最大可以有多少个正序数
 *
 * @author: yry
 * @date: 2020/4/3
 */
public class Test0403 {

    private static void updateTwoMax(int[] arr, int num) {
        if (num > arr[0]) {
            int oldMax = arr[0];
            arr[0] = num;
            arr[1] = oldMax;
        } else if (num == arr[0]) {
            arr[1] = num;
        } else {
            if (num > arr[1]) {
                arr[1] = num;
            }
        }
    }

    private static int solve(int[] arr)  {
        int n = arr.length;
        int[] maxTwo = new int[]{arr[0], Integer.MIN_VALUE};
        Set<Integer> positiveOrderNumIndexSet = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < n; i++) {
            if (arr[i] > maxTwo[0]) {
                positiveOrderNumIndexSet.add(i);
            } else {
                if (maxTwo[1] == Integer.MIN_VALUE) {
                    int preMax = maxTwo[0];
                    map.put(preMax, map.getOrDefault(preMax, 0) + 1);
                } else {
                    int secondMax = maxTwo[1];
                    if (arr[i] > secondMax) {
                        // 说明前面就一个比当前元素大的
                        int preMax = maxTwo[0];
                        map.put(preMax, map.getOrDefault(preMax, 0) + 1);
                    }
                }
            }

            updateTwoMax(maxTwo, arr[i]);
        }

        int count = positiveOrderNumIndexSet.size();
        int ansMax = count;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                continue;
            }

            count += map.get(arr[i]);
            if (positiveOrderNumIndexSet.contains(i)) {
                count--;
            }
            ansMax = Math.max(ansMax, count);
            count = positiveOrderNumIndexSet.size();
        }

        return ansMax;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 5, 2, 3, 4, 8, 7, 2};
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(solve(arr));
    }

}
