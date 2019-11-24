package contest.contest164;

import com.sun.tools.internal.xjc.model.CTypeRef;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem02 {

    public int countServers(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int ans = 0;

        boolean[] rowFlag = new boolean[rowCount];
        boolean[] colFlag = new boolean[colCount];
        int[] rowCountArr = new int[rowCount];
        int[] colCountArr = new int[colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                rowCountArr[i]++;
                colCountArr[j]++;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            if (rowCountArr[i] >= 2) {
                ans += rowCountArr[i];
                rowFlag[i] = true;
            }
        }

        for (int j = 0; j < colCount; j++) {
            if (colCountArr[j] >= 2) {
                int count = colCountArr[j];
                for (int i = 0; i < rowCount; i++) {
                    if (grid[i][j] == 1 && rowFlag[i]) {
                        count--;
                    }
                }
                ans += count;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
