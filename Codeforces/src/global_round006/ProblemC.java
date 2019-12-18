package global_round006;

import java.util.Scanner;

public class ProblemC {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int r = scan.nextInt();
            int c = scan.nextInt();

            if (r == 1 && c == 1) {
                System.out.println(0);
                continue;
            }

            int[][] grid = new int[r][c];
            if (c == 1) {
                for (int i = 0; i < r; i++) {
                    grid[i][0] = 2 + i;
                }
            } else {
                for (int j = 0; j < c; j++) {
                    grid[0][j] = j + 2;
                }

                int nextRowB = c + 2;
                for (int i = 1; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        grid[i][j] = grid[0][j] * nextRowB;
                    }
                    nextRowB++;
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    
}
