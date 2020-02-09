package doubleContest.round19;

import java.util.*;

public class Problem04_1 {

    private Map<Integer, List<Integer>> indexListMap;
    private int[] arr;
    private int len;

    private int bfs() {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[len];
        visited[0] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                if (node == len - 1) {
                     return level;
                }

                if (node + 1 < len && !visited[node + 1]) {
                    visited[node + 1] = true;
                    queue.add(node + 1);
                }

                if (node - 1 >= 0 && !visited[node - 1]) {
                    visited[node - 1] = true;
                    queue.add(node - 1);
                }

                List<Integer> indexList = indexListMap.get(arr[node]);

                for (Integer nextIndex : indexList) {
                    if (!visited[nextIndex]) {
                        visited[nextIndex] = true;
                        queue.add(nextIndex);
                    }
                }

                indexListMap.put(arr[node], new ArrayList<>());
            }
            level++;
        }

        return 0;
    }

    public int minJumps(int[] arr) {
        indexListMap = new HashMap<>();
        this.arr = arr;
        this.len = arr.length;

        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (indexListMap.containsKey(num)) {
                indexListMap.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                indexListMap.put(num, list);
            }
        }

        return bfs();
    }

}

//    给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。
//
//        每一步，你可以从下标 i 跳到下标：
//
//        i + 1 满足：i + 1 < arr.length
//        i - 1 满足：i - 1 >= 0
//        j 满足：arr[i] == arr[j] 且 i != j
//        请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。
//
//        注意：任何时候你都不能跳到数组外面。
