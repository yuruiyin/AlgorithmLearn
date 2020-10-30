package contest.contest212;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/25
 */
public class D {

    class Data {
        int row;
        int col;
        int value;
        Data(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        // 排序
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                list.add(new Data(i, j, matrix[i][j]));
            }
        }

        list.sort(Comparator.comparingInt(o -> o.value));

        int size = list.size();
        int[][] ansGrid = new int[rowCount][colCount];
        int[] rowAnsValueArr = new int[rowCount];
        int[] colAnsValueArr = new int[colCount];
        int[] rowValueArr = new int[rowCount];
        int[] colValueArr = new int[colCount];
        // 最小
        int from = -1;
        Data minData = list.get(0);
        ansGrid[minData.row][minData.col] = 1;
        rowAnsValueArr[minData.row] = 1;
        colAnsValueArr[minData.col] = 1;
        rowValueArr[minData.row] = minData.value;
        colValueArr[minData.col] = minData.value;
        for (int i = 1; i < size; i++) {
            Data data = list.get(i);
            if (data.value > list.get(i-1).value) {
                from = i;
                break;
            }

            ansGrid[data.row][data.col] = 1;
        }

        if (from == -1) {
            return ansGrid;
        }

        int start = from;
        for (int i = from + 1; i < size; i++) {
            Data data = list.get(i);
            if (data.value > list.get(i - 1).value) {
                int end = i - 1;
                //[start, end]
                int count = end - start + 1;
                while (count > 0) {
                    // 先放最大的
                    int maxValue = 0;
                    for (int j = start; j <= end; j++) {
                        Data tmpData = list.get(j);
                        int value = tmpData.value;
                        int row = tmpData.row;
                        int col = tmpData.col;
                        if (ansGrid[row][col] != 0) {
                            continue;
                        }
                        int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                        int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                        int resValue = Math.max(curColValue, curRowValue);
                        maxValue = Math.max(maxValue, resValue);
                    }

                    List<Integer> maxValueIndexList = new ArrayList<>();
                    for (int j = start; j <= end; j++) {
                        Data tmpData = list.get(j);
                        int value = tmpData.value;
                        int row = tmpData.row;
                        int col = tmpData.col;
                        if (ansGrid[row][col] != 0) {
                            continue;
                        }
                        int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                        int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                        int resValue = Math.max(curColValue, curRowValue);
                        if (resValue == maxValue) {
                            maxValueIndexList.add(j);
                        }
                    }

                    for (int idx : maxValueIndexList) {
                        Data tmpData = list.get(idx);
                        int value = tmpData.value;
                        int row = tmpData.row;
                        int col = tmpData.col;
                        if (ansGrid[row][col] != 0) {
                            continue;
                        }
                        int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                        int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                        int resValue = Math.max(curColValue, curRowValue);
                        ansGrid[row][col] = resValue;
                        rowAnsValueArr[row] = resValue;
                        colAnsValueArr[col] = resValue;
                        rowValueArr[row] = value;
                        colValueArr[col] = value;
                        count--;
                    }
                }

                start = i;
            }
        }

        int end = size - 1;
        //[start, end]
        int count = end - start + 1;
        while (count > 0) {
            // 先放最大的
            int maxValue = 0;
            for (int j = start; j <= end; j++) {
                Data tmpData = list.get(j);
                int value = tmpData.value;
                int row = tmpData.row;
                int col = tmpData.col;
                if (ansGrid[row][col] != 0) {
                    continue;
                }
                int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                int resValue = Math.max(curColValue, curRowValue);
                maxValue = Math.max(maxValue, resValue);
            }

            List<Integer> maxValueIndexList = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                Data tmpData = list.get(j);
                int value = tmpData.value;
                int row = tmpData.row;
                int col = tmpData.col;
                if (ansGrid[row][col] != 0) {
                    continue;
                }
                int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                int resValue = Math.max(curColValue, curRowValue);
                if (resValue == maxValue) {
                    maxValueIndexList.add(j);
                }
            }

            for (int idx : maxValueIndexList) {
                Data tmpData = list.get(idx);
                int value = tmpData.value;
                int row = tmpData.row;
                int col = tmpData.col;
                if (ansGrid[row][col] != 0) {
                    continue;
                }
                int curRowValue = value == rowValueArr[row] ? rowAnsValueArr[row] : rowAnsValueArr[row] + 1;
                int curColValue = value == colValueArr[col] ? colAnsValueArr[col] : colAnsValueArr[col] + 1;
                int resValue = Math.max(curColValue, curRowValue);
                ansGrid[row][col] = resValue;
                rowAnsValueArr[row] = resValue;
                colAnsValueArr[col] = resValue;
                rowValueArr[row] = value;
                colValueArr[col] = value;
                count--;
            }
        }

        return ansGrid;
    }

}
