package contest.contest163;

import java.util.ArrayList;
import java.util.List;

public class Problem01 {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> ansList = new ArrayList<>();
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] newGrid = new int[rowCount][colCount];
        int n = rowCount * colCount;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                int index = i * colCount + j;
                int newIndex = (index + k) % n;
                int newI = newIndex / colCount;
                int newJ = newIndex % colCount;
                newGrid[newI][newJ] = grid[i][j];
            }
        }

        for (int i = 0; i < rowCount; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < colCount; j++) {
                list.add(newGrid[i][j]);
            }
            ansList.add(list);
        }

        return ansList;
    }
    
    public static void main(String[] args) {

    }
    
}
