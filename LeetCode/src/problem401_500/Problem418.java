package problem401_500;

/**
 * Problem418
 *
 * @author: yry
 * @date: 2020/4/7
 */
public class Problem418 {

    class Data {
        int row;
        int col;
        Data(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private Data getData(int curCol, String[] sentence, int cols) {
        int curRow = 0;
        for (String word : sentence) {
            int wordLen = word.length();
            if (wordLen > cols) {
                return null;
            }

            if (wordLen > cols - curCol) {
                curCol = 0;
                curRow++;
            }

            if (wordLen >= cols - curCol - 1) {
                curCol = 0;
                curRow++;
            } else {
                curCol += wordLen + 1;
            }
        }

        return new Data(curRow, curCol);
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length == 0) {
            return 0;
        }

        // 先求从第i列开始放句子，看最后到达的row和col
        Data[] datas = new Data[cols];
        for (int j = 0; j < cols; j++) {
            Data data = getData(j, sentence, cols);
            if (data == null) {
                return 0;
            }
            datas[j] = data;
        }

        int curCol = 0;
        int ans = 0;
        int curRow = 0;
        while (curRow < rows) {
            if (ans > 0 && curCol == 0) {
                // 利用上面算出来的直接走到最大行的位置
                int leftRows = rows - curRow;
                ans += ans * (leftRows / curRow);
                curRow = rows - leftRows % curRow;
            }

            Data data = datas[curCol];
            int nextRow = curRow + data.row;
            if (nextRow >= rows) {
                if (nextRow == rows && data.col == 0) {
                    ans++;
                }
                return ans;
            } else {
                ans++;
                curRow = nextRow;
                curCol = data.col;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem418().wordsTyping(new String[]{"ab", "cde", "f"}, 3, 5));
    }

}
