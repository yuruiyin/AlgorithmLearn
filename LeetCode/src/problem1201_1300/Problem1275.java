package problem1201_1300;

public class Problem1275 {

    private String getAns(char[][] grid) {
        for (int i = 0; i < 3; i++) {
            int xCount = 0;
            int oCount = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == 'X') {
                    xCount++;
                } if (grid[i][j] == 'O') {
                    oCount++;
                }
            }

            if (xCount == 3) {
                return "A";
            }

            if (oCount == 3) {
                return "B";
            }
        }

        for (int i = 0; i < 3; i++) {
            int xCount = 0;
            int oCount = 0;
            for (int j = 0; j < 3; j++) {
                if (grid[j][i] == 'X') {
                    xCount++;
                } if (grid[j][i] == 'O') {
                    oCount++;
                }
            }

            if (xCount == 3) {
                return "A";
            }

            if (oCount == 3) {
                return "B";
            }
        }

        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
            return "A";
        }

        if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') {
            return "A";
        }

        if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
            return "B";
        }

        if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O') {
            return "B";
        }

        return "";
    }

    public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];

        boolean isA = true;

        for (int[] move: moves) {
            if (isA) {
                grid[move[0]][move[1]] = 'X';
            } else {
                grid[move[0]][move[1]] = 'O';
            }
            isA = !isA;
        }

        String ans = getAns(grid);

        if (!"".equals(ans)) {
            return ans;
        }

        if (moves.length < 9) {
            return "Pending";
        }

        return "Draw";
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1275().tictactoe(new int[][]{
                {0,0}, {0,1}, {0,2}, {1,0}, {1, 2}, {2, 0}, {2, 1}, {2, 2}
        }));
    }
    
}
