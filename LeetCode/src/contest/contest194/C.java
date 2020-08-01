package contest.contest194;

import utils.PrintUtil;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/21
 */
public class C {

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] ansArr = new int[len];
        Map<Integer, Integer> indexMap = new HashMap<>();
        TreeSet<Integer> zeroIndexSet = new TreeSet<>();

        for (int i = 0; i < len; i++) {
            if (rains[i] > 0) {
                ansArr[i] = -1;
                if (indexMap.containsKey(rains[i])) {
                    // 前面下过雨, 判断前面当前湖子下过雨那天后面是否有0
                    int index = indexMap.get(rains[i]);
                    Integer zeroIndex = zeroIndexSet.ceiling(index);
                    if (zeroIndex == null) {
                        // 没找到
                        return new int[0];
                    }

                    ansArr[zeroIndex] = rains[i];
                    zeroIndexSet.remove(zeroIndex);
                    indexMap.put(rains[i], i);
                } else {
                    indexMap.put(rains[i], i);
                }
            } else {
                zeroIndexSet.add(i);
            }
        }

        for (int i = 0; i < len; i++) {
            if (ansArr[i] == 0) {
                ansArr[i] = 1;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
//        int[] ansArr = new C().avoidFlood(new int[]{1, 2, 0, 0, 2, 1});
//        int[] ansArr = new C().avoidFlood(new int[]{1,2,0,2,3,0,1});
        int[] ansArr = new C().avoidFlood(new int[]{2,3,0,0,3,1,0,1,0,2,2});
        PrintUtil.printIntArray(ansArr);
    }

}
