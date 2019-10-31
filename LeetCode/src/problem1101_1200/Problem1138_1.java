package problem1101_1200;

public class Problem1138_1 {

    private void handleRowMove(StringBuilder sb, int row, int lastRow) {
        int count = Math.abs(row - lastRow);
        while ((count--) > 0) {
            sb.append(lastRow > row ? 'U' : 'D');
        }
    }

    private void handleColMove(StringBuilder sb, int col, int lastCol) {
        int count = Math.abs(col - lastCol);
        while ((count--) > 0) {
            sb.append(lastCol > col ? 'L' : 'R');
        }
    }

    public String alphabetBoardPath(String target) {
        char[][] board = new char[][]{
                "abcde".toCharArray(),
                "fghij".toCharArray(),
                "klmno".toCharArray(),
                "pqrst".toCharArray(),
                "uvwxy".toCharArray(),
                "z".toCharArray()
        };

        int len = target.length();
        StringBuilder sb = new StringBuilder();
        int lastRow = 0;
        int lastCol = 0;
        char lastChar = 'a';
        for (int i = 0; i < len; i++) {
            char c = target.charAt(i);

            int row = (c - 'a') / 5;
            int col = (c - 'a') % 5;

            if (lastChar == 'z') {
                // 先上移
                handleRowMove(sb, row, lastRow);
                handleColMove(sb, col, lastCol);
            } else {
                handleColMove(sb, col, lastCol);
                handleRowMove(sb, row, lastRow);
            }
            sb.append('!');
            lastRow = row;
            lastCol = col;
            lastChar = c;
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        
    }
    
}
