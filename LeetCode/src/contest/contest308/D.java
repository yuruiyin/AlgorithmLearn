package contest.contest308;

import java.util.*;

public class D {

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // 拓扑排序  [abovei, belowi]， [lefti, righti]
        List<Integer>[] rowAdj = new ArrayList[k + 1];
        Arrays.setAll(rowAdj, value -> new ArrayList<>());
        int[] rowInDegree = new int[k + 1];
        Set<Integer> rowVisited = new HashSet<>();
        for (int i = 0; i < rowConditions.length; i++) {
            int above = rowConditions[i][0];
            int below = rowConditions[i][1];
            rowInDegree[below]++;
            rowVisited.add(above);
            rowVisited.add(below);
            rowAdj[above].add(below);
        }

        List<Integer>[] colAdj = new ArrayList[k + 1];
        Arrays.setAll(colAdj, value -> new ArrayList<>());
        int[] colInDegree = new int[k + 1];
        Set<Integer> colVisited = new HashSet<>();
        for (int i = 0; i < colConditions.length; i++) {
            int left = colConditions[i][0];
            int right = colConditions[i][1];
            colInDegree[right]++;
            colVisited.add(left);
            colVisited.add(right);
            colAdj[left].add(right);
        }

        List<Integer> rowList = new ArrayList<>();
        LinkedList<Integer> rowQueue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (rowVisited.contains(i) && rowInDegree[i] == 0) {
                rowQueue.add(i);
            }
        }

        if (rowQueue.isEmpty()) {
            return new int[0][0];
        }

        boolean[] tmpVisited = new boolean[k + 1];
        int count = 0;
        while (!rowQueue.isEmpty()) {
            int size = rowQueue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int node = rowQueue.poll();
                rowList.add(node);
                tmpVisited[node] = true;
                List<Integer> nextList = rowAdj[node];
                for (int next : nextList) {
                    if (tmpVisited[next]) {
                        return new int[0][0];
                    }
                    rowInDegree[next]--;
                    if (rowInDegree[next] == 0) {
                        rowQueue.add(next);
                    }
                }
            }
        }

        if (count != rowVisited.size()) {
            return new int[0][0];
        }

        List<Integer> colList = new ArrayList<>();
        LinkedList<Integer> colQueue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (colVisited.contains(i) && colInDegree[i] == 0) {
                colQueue.add(i);
            }
        }

        if (colQueue.isEmpty()) {
            return new int[0][0];
        }

        count = 0;
        boolean[] tmpVisited1 = new boolean[k + 1];
        while (!colQueue.isEmpty()) {
            int size = colQueue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int node = colQueue.poll();
                colList.add(node);
                tmpVisited1[node] = true;
                List<Integer> nextList = colAdj[node];
                for (int next : nextList) {
                    if (tmpVisited1[next]) {
                        return new int[0][0];
                    }
                    colInDegree[next]--;
                    if (colInDegree[next] == 0) {
                        colQueue.add(next);
                    }
                }
            }
        }

        if (count != colVisited.size()) {
            return new int[0][0];
        }

        int[][] ansGrid = new int[k][k];
        int[][] indexMap = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            indexMap[i][0] = -1;
            indexMap[i][1] = -1;
        }
        for (int i = 0; i < rowList.size(); i++) {
            int value = rowList.get(i);
            indexMap[value][0] = i;
        }

        for (int i = 0; i < colList.size(); i++) {
            int value = colList.get(i);
            indexMap[value][1] = i;
        }

        int emptyRow = rowList.size();
        int emptyCol = colList.size();
        for (int i = 1; i <= k; i++) {
            int[] indexArr = indexMap[i];
            int row = indexArr[0];
            int col = indexArr[1];
            if (row == -1 && col == -1) {
                continue;
            } else if (row == -1) {
                ansGrid[emptyRow][col] = i;
                emptyRow++;
            } else if (col == -1) {
                ansGrid[row][emptyCol] = i;
                emptyCol++;
            } else {
                ansGrid[row][col] = i;
            }
        }
        return ansGrid;
    }

}
