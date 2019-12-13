package problem501_600;

import java.util.*;

public class Problem546 {

    private Map<String, Integer> memoMap;

    private Map<Integer, List<Integer>> getIndexListMap(List<Integer> boxList) {
        Map<Integer, List<Integer>> indexListMap = new HashMap<>();
        int size = boxList.size();

        for (int i = 0; i < size; i++) {
            int box = boxList.get(i);
            if (!indexListMap.containsKey(box)) {
                indexListMap.put(box, new ArrayList<>());
            }
            indexListMap.get(box).add(i);
        }

        return indexListMap;
    }

    private List<int[]> getIntervalList(List<Integer> boxList) {
        if (boxList.isEmpty()) {
            return new ArrayList<>();
        }

        List<int[]> intervalList = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i < boxList.size(); i++) {
            int box = boxList.get(i);
            int prevBox = boxList.get(i-1);
            if (box != prevBox) {
                intervalList.add(new int[]{start, end});
                start = i;
                end = i;
            } else {
                end++;
            }
        }

        intervalList.add(new int[]{start, end});

        return intervalList;
    }

    private String listToStr(List<Integer> boxList) {
        StringBuilder sb = new StringBuilder();
        for (Integer box : boxList) {
            sb.append(box).append('_');
        }

        return sb.toString();
    }

    private int backTrack(List<Integer> boxList) {
        // 每一次递归boxList就是删除之后剩下的盒子列表
        // 只要有盒子就出现在一个连续区间，则可以都先删掉
        // 否则，就需要遍历删除各种盒子的情况, 取最大值即可
        if (boxList.isEmpty()) {
            return 0;
        }

        String key = listToStr(boxList);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        List<Integer> tmpList = boxList;
        int score = 0;
        List<Integer> nextBoxList = boxList;
        while (true) {
            Map<Integer, List<Integer>> indexListMap = getIndexListMap(tmpList);

            Set<Integer> singleIntervalBoxSet = new HashSet<>();
            for (Integer box: indexListMap.keySet()) {
                List<Integer> indexList = indexListMap.get(box);
                int size = indexList.size();
                boolean isInSingleInterval = true;
                for (int i = 0; i < size - 1; i++) {
                    if (indexList.get(i) + 1 != indexList.get(i+1)) {
                        isInSingleInterval = false;
                        break;
                    }
                }

                if (isInSingleInterval) {
                    singleIntervalBoxSet.add(box);
                }
            }

            if (singleIntervalBoxSet.isEmpty()) {
                nextBoxList = tmpList;
                break;
            }

            List<Integer> tmpNextBoxList = new ArrayList<>();
            for (Integer box: tmpList) {
                if (!singleIntervalBoxSet.contains(box)) {
                    tmpNextBoxList.add(box);
                } else {
                    int k = indexListMap.get(box).size();
                    score += k;
                }
            }

            tmpList = tmpNextBoxList;
        }

        int max = 0;
        int nextBoxListSize = nextBoxList.size();
        List<int[]> intervalList = getIntervalList(nextBoxList);
        for (int[] interval: intervalList) {
            List<Integer> list = new ArrayList<>();
            int start = interval[0];
            int end = interval[1];
            for (int i = 0; i < nextBoxListSize; i++) {
                if (i < start || i > end) {
                    list.add(nextBoxList.get(i));
                }
            }

            int k = end - start + 1;
            int res = backTrack(list) + k * k;
            if (res > max) {
                max = res;
            }
        }

        int ans = score + max;
        memoMap.put(key, ans);
        return ans;
    }

    public int removeBoxes(int[] boxes) {
        List<Integer> boxList = new ArrayList<>();
        for (int box: boxes) {
            boxList.add(box);
        }

        memoMap = new HashMap<>();
        return backTrack(boxList);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem546().removeBoxes(new int[]{1, 1}));
        System.out.println(new Problem546().removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }

}

//  给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
//        你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k 个积分。
//        当你将所有盒子都去掉之后，求你能获得的最大积分和。
//
//        示例 1：
//        输入:
//
//        [1, 3, 2, 2, 2, 3, 4, 3, 1]
//        输出:
//
//        23
//        解释:
//
//        [1, 3, 2, 2, 2, 3, 4, 3, 1]
//        ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
//        ----> [1, 3, 3, 3, 1] (1*1=1 分)
//        ----> [1, 1] (3*3=9 分)
//        ----> [] (2*2=4 分)
//         
//
//        提示：盒子的总数 n 不会超过 100。

