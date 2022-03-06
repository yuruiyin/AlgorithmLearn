package contest.contest267;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/14
 */
public class C {

    public String decodeCiphertext(String encodedText, int rows) {
        char[] arr = encodedText.toCharArray();
        int len = arr.length;
        int cols = len / rows;
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = arr[i * cols + j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < cols; j++) {
            int curI = 0;
            int curJ = j;
            sb.append(grid[curI][curJ]);
            for (int offset = 1; curI + offset < rows && curJ + offset < cols; offset++) {
                sb.append(grid[curI + offset][curJ + offset]);
            }
        }
        StringBuilder ansSb = new StringBuilder();
        boolean hasNoEmpty = false;
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) != ' ') {
                hasNoEmpty = true;
            }
            if (hasNoEmpty) {
                ansSb.append(sb.charAt(i));
            }
        }

        return ansSb.reverse().toString();
    }

}
