package contest.contest097;

public class Problem885 {

    public int[][] spiralMatrixIII(int rowCount, int colCount, int r0, int c0) {
        int direction = 0; // 右
        int curRow = r0;
        int curCol = c0;
        int size = rowCount * colCount;
        int[][] ansArr = new int[size][2];
        int index = 0;
        int top = curRow;
        int bottom = curRow;
        int left = curCol;
        int right = curCol;
        ansArr[index++] = new int[]{curRow, curCol};
        while (index < size) {
            if (direction == 0) {
                if (curRow >= 0 && curRow < rowCount) {
                    for (int j = curCol + 1; j <= right + 1; j++) {
                        if (j < 0) {
                            continue;
                        }

                        if (j >= colCount) {
                            break;
                        }

                        ansArr[index++] = new int[]{curRow, j};
                    }
                }
                curCol = right + 1;
                direction = 1;
                right++;
            } else if (direction == 1) {
                if (curCol >= 0 && curCol < colCount) {
                    for (int i = curRow + 1; i <= bottom + 1; i++) {
                        if (i < 0) {
                            continue;
                        }
                        if (i >= rowCount) {
                            break;
                        }
                        ansArr[index++] = new int[]{i, curCol};
                    }
                }

                curRow = bottom + 1;
                direction = 2;
                bottom++;
            } else if (direction == 2) {
                if (curRow >= 0 && curRow < rowCount) {
                    for (int j = curCol - 1; j >= left - 1; j--) {
                        if (j >= colCount) {
                            continue;
                        }
                        if (j < 0) {
                            break;
                        }

                        ansArr[index++] = new int[]{curRow, j};
                    }
                }

                curCol = left - 1;
                direction = 3;
                left--;
            } else {
                if (curCol >= 0 && curCol < colCount) {
                    for (int i = curRow - 1; i >= top - 1; i--) {
                        if (i >= rowCount) {
                            continue;
                        }
                        if (i < 0) {
                            break;
                        }
                        ansArr[index++] = new int[]{i, curCol};
                    }
                }

                curRow = top - 1;
                direction = 0;
                top--;
            }
        }

        return ansArr;
    }

    public static void main(String[] args) {
        new Problem885().spiralMatrixIII(1, 4, 0 ,0);
    }

}
