package problem1101_1200;

import java.util.*;

/**
 * Problem1168
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class Problem1168 {

    class Data {
        int minWell;
        List<Integer> houseList;
        int totalCost;
        Data(int minWell, List<Integer> houseList, int totalCost) {
            this.minWell = minWell;
            this.houseList = houseList;
            this.totalCost = totalCost;
        }
    }

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // 并查集, 每个集合选择房子造水井的最小费用
        Data[] treeArr = new Data[n + 1];
        Arrays.sort(pipes, Comparator.comparingInt(o -> o[2])); // cost从小到大排序

        for (int[] pipe : pipes) {
            int h1 = pipe[0] - 1;
            int h2 = pipe[1] - 1;
            int cost = pipe[2];

            Data tree1 = treeArr[h1];
            Data tree2 = treeArr[h2];

            // 比较合并后的费用和不合并的费用
            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                int mergeCost = cost + tree1.totalCost + tree2.totalCost + Math.min(tree1.minWell, tree2.minWell);
                int notMergeCost = tree1.totalCost + tree1.minWell + tree2.totalCost + tree2.minWell;

                if (mergeCost >= notMergeCost) {
                    // 不合并
                    continue;
                }

                if (tree1.minWell < tree2.minWell) {
                    // tree2合并到tree1，
                    tree1.houseList.addAll(tree2.houseList);
                    for (Integer id : tree2.houseList) {
                        treeArr[id] = tree1;
                    }
                    tree1.totalCost += cost + tree2.totalCost;
                } else {
                    // tree1合并到tree2，
                    tree2.houseList.addAll(tree1.houseList);
                    for (Integer id : tree1.houseList) {
                        treeArr[id] = tree2;
                    }
                    tree2.totalCost += cost + tree1.totalCost;
                }
            } else if (tree1 != null) {
                int mergeCost = cost + tree1.totalCost + Math.min(tree1.minWell, wells[h2]);
                int notMergeCost = tree1.totalCost + tree1.minWell + wells[h2];
                if (mergeCost >= notMergeCost) {
                    continue;
                }

                tree1.houseList.add(h2);
                tree1.minWell = Math.min(tree1.minWell, wells[h2]);
                tree1.totalCost += cost;
                treeArr[h2] = tree1;
            } else if (tree2 != null) {
                int mergeCost = cost + tree2.totalCost + Math.min(tree2.minWell, wells[h1]);
                int notMergeCost = tree2.totalCost + tree2.minWell + wells[h1];
                if (mergeCost >= notMergeCost) {
                    continue;
                }

                tree2.houseList.add(h1);
                tree2.minWell = Math.min(tree2.minWell, wells[h1]);
                tree2.totalCost += cost;
                treeArr[h1] = tree2;
            } else {
                int minWell = Math.min(wells[h1], wells[h2]);
                int mergeCost = cost + minWell;
                int notMergeCost = wells[h1] + wells[h2];
                if (mergeCost >= notMergeCost) {
                    continue;
                }

                List<Integer> houseList = new ArrayList<>(Arrays.asList(h1, h2));
                Data data = new Data(minWell, houseList, cost);
                treeArr[h1] = data;
                treeArr[h2] = data;
            }
        }

        Set<Data> set = new HashSet<>();
        int onlyOneNodeSum = 0;
        for (int i = 0; i < n; i++) {
            if (treeArr[i] == null) {
                onlyOneNodeSum += wells[i];
            } else {
                set.add(treeArr[i]);
            }
        }

        int ans = 0;
        for (Data data : set) {
            ans += data.totalCost + data.minWell;
        }
        return ans + onlyOneNodeSum;
    }

}
