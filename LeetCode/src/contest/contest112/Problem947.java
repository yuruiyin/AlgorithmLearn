package contest.contest112;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem947 {

    public int removeStones(int[][] stones) {
        // 并查集，根据行列。最多的石头移除次数就是总石头数-并查集的个数（也就是最后剩下的石头个数）
        // 因为有多少个并查集，每个并查集最后肯定会有一个石头剩下。
        List<int[]>[] treeArr = new ArrayList[20000];

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1];
            List<int[]> tree1 = treeArr[row];
            List<int[]> tree2 = treeArr[col + 10000];

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                tree1.addAll(tree2);
                for (int[] tmpStone: tree2) {
                    treeArr[tmpStone[0]] = tree1;
                    treeArr[tmpStone[1] + 10000] = tree1;
                }

            } else if (tree1 != null) {
                tree1.add(stone);
                treeArr[col + 10000] = tree1;
            } else if (tree2 != null) {
                tree2.add(stone);
                treeArr[row] = tree2;
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(stone);
                treeArr[row] = list;
                treeArr[col + 10000] = list;
            }
        }

        Set<List<int[]>> set = new HashSet<>();
        for (int i = 0; i < 20000; i++) {
            if (treeArr[i] == null) {
                continue;
            }
            set.add(treeArr[i]);
        }

        return stones.length - set.size();
    }

}
