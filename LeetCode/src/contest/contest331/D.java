package contest.contest331;

import java.util.*;

public class D {

    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        int leftMinNum = Integer.MAX_VALUE;
        int rightMinNum = Integer.MAX_VALUE;
        for (int num : basket1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
            leftMinNum = Math.min(leftMinNum, num);
        }
        for (int num : basket2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
            rightMinNum = Math.min(rightMinNum, num);
        }

        for (int key : countMap.keySet()) {
            int count = countMap.get(key);
            if (count % 2 != 0) {
                return -1;
            }
        }

        List<Integer> leftList = new ArrayList<>();
        for (int key : countMap1.keySet()) {
            int count1 = countMap1.get(key);
            int totalCount = countMap.get(key);
            if (count1 > totalCount / 2) {
                int count = count1 - totalCount / 2;
                while ((count--) > 0) {
                    leftList.add(key);
                }
            }
        }

        Collections.sort(leftList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        List<Integer> rightList = new ArrayList<>();
        for (int key : countMap2.keySet()) {
            int count2 = countMap2.get(key);
            int totalCount = countMap.get(key);
            if (count2 > totalCount / 2) {
                int count = count2 - totalCount / 2;
                while ((count--) > 0) {
                    rightList.add(key);
                }
            }
        }

        Collections.sort(rightList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int leftS = 0;
        int leftE = leftList.size() - 1;
        int rightS = 0;
        int rightE = rightList.size() - 1;
        long ans = 0;
        int min = Math.min(leftMinNum * 2, rightMinNum * 2);
        while (leftS <= leftE) {
            if (leftList.get(leftS) >= rightList.get(rightS)) {
                ans += Math.min(
                        Math.min(leftList.get(leftS), rightList.get(rightE)),
                        min
                );
                leftS++;
                rightE--;
            } else {
                ans += Math.min(
                        Math.min(rightList.get(rightS), leftList.get(leftE)),
                        min
                );
                rightS++;
                leftE--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        [84,80,43,8,80,88,43,14,100,88]
//[32,32,42,68,68,100,42,84,14,8]
//        System.out.println(new D().minCost(new int[]{84, 80, 43, 8, 80, 88, 43, 14, 100, 88}, new int[]{32, 32, 42, 68, 68, 100, 42, 84, 14, 8}));
//        [3,3,9,9]
//[2,2,10,10]
        System.out.println(new D().minCost(new int[]{1, 3,3,9,9}, new int[]{1, 2,2,10,10}));
    }

}
