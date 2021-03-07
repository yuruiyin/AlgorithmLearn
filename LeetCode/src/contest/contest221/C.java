package contest.contest221;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/27
 */
public class C {

    public int[] findBall(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[] ansArr = new int[colCount];

        for (int j = 0; j < colCount; j++) {
            int i = 0;
            int curJ = j;
            boolean isOk = true;
            while (i < rowCount) {
                if (grid[i][curJ] == 1) {
                    if (curJ == colCount - 1 || grid[i][curJ + 1] == -1) {
                        isOk = false;
                        break;
                    }

                    i++;
                    curJ++;
                } else {
                    if (curJ == 0 || grid[i][curJ - 1] == 1) {
                        isOk = false;
                        break;
                    }

                    i++;
                    curJ--;
                }
            }

            ansArr[j] = isOk ? curJ : -1;
        }

        return ansArr;

    }

}
