package problem201_300;

import javafx.util.Pair;
import utils.PrintUtil;
import utils.TreeMultiSet;

import java.util.*;

public class Problem218 {

    // 使用扫描线算法，从左往右扫描，碰到某个建筑物的左端点，则将左端点对应的高度入堆，碰到某个建筑物的右端点，则将该建筑物的高度出堆。
    // 在高度入堆之前，判断要加入的高度是否大于当前堆中的最大高度，如果大的话，则说明产生了一个新拐点。
    // 在高度出堆的时候，出堆以后，判断剩下的堆中的最大高度是否等于出堆的那个高度，如果不等的话，说明也产生了一个拐点
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ansList = new ArrayList<>();
        Set<Pair<Integer, Integer>> pairs = new TreeSet<>(
                (o1, o2) -> !o1.getKey().equals(o2.getKey()) ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue()
        );

        for (int[] build : buildings) {
            pairs.add(new Pair<>(build[0], -build[2]));
            pairs.add(new Pair<>(build[1], build[2]));
        }

        TreeMultiSet<Integer> multiSet = new TreeMultiSet<>((o1, o2) -> o2 - o1);

        for (Pair<Integer, Integer> pair : pairs) {
            int curMaxHeight = multiSet.isEmpty() ? 0 : multiSet.first();
            int curHeight = pair.getValue();
            if (curHeight < 0) {
                // value小于0，代表左端点，高度要入堆的，先判断高度是否大于当前堆中最大高度，大的话，产生一拐点
                if (-curHeight > curMaxHeight) {
                    ansList.add(new ArrayList<>(Arrays.asList(pair.getKey(), -curHeight)));
                }

                multiSet.add(-curHeight);
            } else {
                // value大于0，代表右端点，高度需要出堆
                int beforeMaxHeight = multiSet.first();
                multiSet.remove(curHeight);
                if (multiSet.isEmpty()) {
                    ansList.add(new ArrayList<>(Arrays.asList(pair.getKey(), 0)));
                } else if (multiSet.first() != beforeMaxHeight) {
                    ansList.add(new ArrayList<>(Arrays.asList(pair.getKey(), multiSet.first())));
                }
            }
        }

        return ansList;
    }
    
    public static void main(String[] args) {
        int[][] buildings = new int[][]{
                {2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}
        };
        List<List<Integer>> ansList = new Problem218().getSkyline(buildings);
        PrintUtil.printIntListList(ansList);
    }

}
