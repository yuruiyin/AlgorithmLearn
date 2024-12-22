package contest.contest427;

import java.util.*;

public class D {

    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        // 每个点都记录自己最接近的右方和上方的点
        int len = xCoord.length;
        Map<Integer, Integer> rightMap = new HashMap<>();
        Map<Integer, Integer> topMap = new HashMap<>();

        // key 是 x, value是 y轴上的点的索引
        TreeMap<Integer, TreeSet<Integer>> xTreeSetMap = new TreeMap<>();
        // key 是 y, value是 x 轴上的点的索引
        TreeMap<Integer, TreeSet<Integer>> yTreeSetMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int x = xCoord[i];
            int y = yCoord[i];
            if (!xTreeSetMap.containsKey(x)) {
                xTreeSetMap.put(x, new TreeSet<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return yCoord[o1] - yCoord[o2];
                    }
                }));
            }

            xTreeSetMap.get(x).add(i);

            if (!yTreeSetMap.containsKey(y)) {
                yTreeSetMap.put(y, new TreeSet<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return xCoord[o1] - xCoord[o2];
                    }
                }));
            }

            yTreeSetMap.get(y).add(i);
        }

        for (int x : xTreeSetMap.keySet()) {
            TreeSet<Integer> yIdxSet = xTreeSetMap.get(x);

        }

        // todo
        return 0;
    }

}
