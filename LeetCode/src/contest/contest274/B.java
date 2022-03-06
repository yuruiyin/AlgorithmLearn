package contest.contest274;

/**
 * A
 *
 * @author: yry
 * @date: 2022/1/2
 */
public class B {

    public int numberOfBeams(String[] bank) {
        int rowCount = bank.length;
        int colCount = bank[0].length();
        char[][] grid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            grid[i] = bank[i].toCharArray();
        }

        int preCount = 0;

        int ans = 0;

        for (int i = 0; i < rowCount; i++) {
            int count = 0;
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }

            if (count == 0) {
                continue;
            }

            if (preCount != 0) {
                ans += preCount * count;
            }

            preCount = count;
        }

        return ans;
    }

}
