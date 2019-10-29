package problem1101_1200;

import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem1182 {

    private int binarySearch(ArrayList<Integer> indexList, int target) {
        int low = 0;
        int high = indexList.size() - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midValue = indexList.get(mid);
            if (midValue == target) {
                return 0;
            } else if (target < midValue) {
                if (mid == 0 || target > indexList.get(mid-1)) {
                    if (mid == 0) {
                        return midValue - target;
                    }
                    return Math.min(midValue - target, target - indexList.get(mid-1));
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return target - indexList.get(low - 1);
    }

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        // 二分
        int n = colors.length;
        ArrayList<Integer>[] indexListArr = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            indexListArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int color = colors[i];
            indexListArr[color-1].add(i);
        }

        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int qIndex = queries[i][0];
            int qColor = queries[i][1];

            if (indexListArr[qColor-1].isEmpty()) {
                ansList.add(-1);
            } else {
                ansList.add(binarySearch(indexListArr[qColor-1], qIndex));
            }
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<Integer> ansList = new Problem1182().shortestDistanceColor(new int[]{1,1,2,1,3,2,2,3,3}, new int[][]{
                {1,3},
                {2,2},
                {6,1}
        });

        PrintUtil.printIntList(ansList);

        List<Integer> ansList1 = new Problem1182().shortestDistanceColor(new int[]{1,2}, new int[][]{
                {0,3},
        });

        PrintUtil.printIntList(ansList1);
    }
}
//
//        示例 1：
//
//        输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//        输出：[3,0,3]
//        解释：
//        距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//        距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//        距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
//        示例 2：
//
//        输入：colors = [1,2], queries = [[0,3]]
//        输出：[-1]
//        解释：colors 中没有颜色 3。
//
//
//        提示：
//
//        1 <= colors.length <= 5*10^4
//        1 <= colors[i] <= 3
//        1 <= queries.length <= 5*10^4
//        queries[i].length == 2
//        0 <= queries[i][0] < colors.length
//        1 <= queries[i][1] <= 3
