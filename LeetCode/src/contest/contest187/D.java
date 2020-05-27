package contest.contest187;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/3
 */
public class D {

    public int kthSmallest(int[][] mat, int k) {
        List<Integer> ansList = new ArrayList<>();
        ansList.add(0);
        for (int[] curRow : mat) {
            List<Integer> tmpList = new ArrayList<>();
            for (Integer x : ansList) {
                for (int y : curRow) {
                    tmpList.add(x + y);
                }
            }
            Collections.sort(tmpList);
            ansList = tmpList.subList(0, Math.min(k, tmpList.size()));
        }

        return ansList.get(k - 1);
    }

    public static void main(String[] args) {
//        System.out.println(new D().kthSmallest(new int[][] {
//                {1, 3, 11}, {2, 4, 6}
//        }, 9));

        System.out.println(new D().kthSmallest(new int[][]{
                {1, 10, 10}, {1, 4, 5}, {2, 3, 6}
        }, 7)); // 9

//        System.out.println(new D().kthSmallest(new int[][]{
//                {1}, {2}
//        }, 1));

//        TreeSet<Node> treeSet = new TreeSet<>();
//        treeSet.add(new Node(5, new int[]{0, 1, 1}));
//        treeSet.add(new Node(5, new int[]{1, 0}));
//        System.out.println(treeSet.size());

//        Set<Node> treeSet = new HashSet<>();
//        treeSet.add(new Node(5, new int[]{0, 1}));
//        treeSet.add(new Node(5, new int[]{1, 0}));
//        System.out.println(treeSet.size());
    }

}
