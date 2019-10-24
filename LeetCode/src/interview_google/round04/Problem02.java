package interview_google.round04;

public class Problem02 {

    private int handleRow(StringBuilder sb, int row, int lastRow) {
        // D or U
        if (row != lastRow) {
            int count = Math.abs(row - lastRow);
            while ((count--) > 0) {
                sb.append(row > lastRow ? 'D' : 'U');
            }
        }

        return row;
    }

    private int handleCol(StringBuilder sb, int col, int lastCol) {
        // L or R
        if (col != lastCol) {
            int count = Math.abs(col - lastCol);
            while ((count--) > 0) {
                sb.append(col > lastCol ? 'R' : 'L');
            }
        }

        return col;
    }

    public String alphabetBoardPath(String target) {
        char[][] board = new char[6][5];
        board[0] = "abcde".toCharArray();
        board[1] = "fghij".toCharArray();
        board[2] = "klmno".toCharArray();
        board[3] = "pqrst".toCharArray();
        board[4] = "uvwxy".toCharArray();
        board[5] = "z".toCharArray();

        int len = target.length();
        int lastRow = 0;
        int lastCol = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char curChar = target.charAt(i);

            int row = (curChar - 'a') / 5;
            int col = (curChar - 'a') % 5;

            if (lastRow == 5) {
                // 上个字符是z，先行后列
                lastRow = handleRow(sb, row, lastRow);
                lastCol = handleCol(sb, col, lastCol);
            } else {
                lastCol = handleCol(sb, col, lastCol);
                lastRow = handleRow(sb, row, lastRow);
            }

            sb.append('!');
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem02().alphabetBoardPath("leet"));
        System.out.println(new Problem02().alphabetBoardPath("code"));
        System.out.println(new Problem02().alphabetBoardPath("zdz"));
        System.out.println(new Problem02().alphabetBoardPath("zb"));
    }
    
}
