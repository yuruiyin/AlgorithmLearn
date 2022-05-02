package contest.contest289;

public class C {

    private int getMaxTailZeros(Data value) {
        return Math.min(value.count2, value.count5);
    }

    class Data {
        int count2;
        int count5;

        Data(){}

        Data(int count2, int count5) {
            this.count2 = count2;
            this.count5 = count5;
        }
    }

    private int getCount2(int value) {
        int count = 0;
        while (value > 0 && value % 2 == 0) {
            count++;
            value /= 2;
        }
        return count;
    }

    private int getCount5(int value) {
        int count = 0;
        while (value > 0 && value % 5 == 0) {
            count++;
            value /= 5;
        }
        return count;
    }

    private Data getData(int value) {
        return new Data(getCount2(value), getCount5(value));
    }

    public int maxTrailingZeros(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        Data[][] rowPreSumArr = new Data[rowCount][colCount];
        int ansMax = 0;
        for (int i = 0; i < rowCount; i++) {
            rowPreSumArr[i][0] = getData(grid[i][0]);
            for (int j = 1; j < colCount; j++) {
                rowPreSumArr[i][j] = new Data();
                rowPreSumArr[i][j].count2 = rowPreSumArr[i][j - 1].count2 + getCount2(grid[i][j]);
                rowPreSumArr[i][j].count5 = rowPreSumArr[i][j - 1].count5 + getCount5(grid[i][j]);
            }
        }

        Data[][] colPreSumArr = new Data[rowCount][colCount];
        for (int j = 0; j < colCount; j++) {
            colPreSumArr[0][j] = getData(grid[0][j]);
            for (int i = 1; i < rowCount; i++) {
                colPreSumArr[i][j] = new Data();
                colPreSumArr[i][j].count2 = colPreSumArr[i - 1][j].count2 + getCount2(grid[i][j]);
                colPreSumArr[i][j].count5 = colPreSumArr[i - 1][j].count5 + getCount5(grid[i][j]);
            }
        }

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (j == colCount - 1) {
                    ansMax = Math.max(ansMax, getMaxTailZeros(rowPreSumArr[i][j]));
                }
                if (i == rowCount - 1) {
                    ansMax = Math.max(ansMax, getMaxTailZeros(colPreSumArr[i][j]));
                }
            }
        }

        //  遍历每个转折点
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                // 左下
                if (j > 0 && i < rowCount - 1) {
                    int leftCount2 = rowPreSumArr[i][j].count2;
                    int leftCount5 = rowPreSumArr[i][j].count5;
                    int bottomCount2 = i == 0 ? colPreSumArr[rowCount - 1][j].count2 : (colPreSumArr[rowCount - 1][j].count2 - colPreSumArr[i - 1][j].count2);
                    int bottomCount5 = i == 0 ? colPreSumArr[rowCount - 1][j].count5 : (colPreSumArr[rowCount - 1][j].count5 - colPreSumArr[i - 1][j].count5);
                    int count2 = leftCount2 + bottomCount2 - getCount2(grid[i][j]);
                    int count5 = leftCount5 + bottomCount5 - getCount5(grid[i][j]);
                    ansMax = Math.max(ansMax, Math.min(count2, count5));
                }

                // 左上
                if (j > 0 && i > 0) {
                    int leftCount2 = rowPreSumArr[i][j].count2;
                    int leftCount5 = rowPreSumArr[i][j].count5;
                    int topCount2 = colPreSumArr[i][j].count2;
                    int topCount5 = colPreSumArr[i][j].count5;
                    int count2 = leftCount2 + topCount2 - getCount2(grid[i][j]);
                    int count5 = leftCount5 + topCount5 - getCount5(grid[i][j]);
                    ansMax = Math.max(ansMax, Math.min(count2, count5));
                }

                // 右下
                if (j < colCount - 1 && i < rowCount - 1) {
                    int rightCount2 = j == 0 ? rowPreSumArr[i][colCount - 1].count2 : (rowPreSumArr[i][colCount - 1].count2 - rowPreSumArr[i][j - 1].count2);;
                    int rightCount5 = j == 0 ? rowPreSumArr[i][colCount - 1].count5 : (rowPreSumArr[i][colCount - 1].count5 - rowPreSumArr[i][j - 1].count5);
                    int bottomCount2 = i == 0 ? colPreSumArr[rowCount - 1][j].count2 : (colPreSumArr[rowCount - 1][j].count2 - colPreSumArr[i - 1][j].count2);
                    int bottomCount5 = i == 0 ? colPreSumArr[rowCount - 1][j].count5 : (colPreSumArr[rowCount - 1][j].count5 - colPreSumArr[i - 1][j].count5);
                    int count2 = rightCount2 + bottomCount2 - getCount2(grid[i][j]);
                    int count5 = rightCount5 + bottomCount5 - getCount5(grid[i][j]);
                    ansMax = Math.max(ansMax, Math.min(count2, count5));
                }

                // 右上
                if (j < colCount - 1 && i > 0) {
                    int rightCount2 = j == 0 ? rowPreSumArr[i][colCount - 1].count2 : (rowPreSumArr[i][colCount - 1].count2 - rowPreSumArr[i][j - 1].count2);;
                    int rightCount5 = j == 0 ? rowPreSumArr[i][colCount - 1].count5 : (rowPreSumArr[i][colCount - 1].count5 - rowPreSumArr[i][j - 1].count5);
                    int topCount2 = colPreSumArr[i][j].count2;
                    int topCount5 = colPreSumArr[i][j].count5;
                    int count2 = rightCount2 + topCount2 - getCount2(grid[i][j]);
                    int count5 = rightCount5 + topCount5 - getCount5(grid[i][j]);
                    ansMax = Math.max(ansMax, Math.min(count2, count5));
                }
            }
        }

        return ansMax;

    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
