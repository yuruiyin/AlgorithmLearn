package round608;

import java.util.Scanner;

public class Problem03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sx = scanner.nextInt();
            int sy = scanner.nextInt();

            // 只要建在学校四个方向出去的第一个位置即可
            int[][] houses = new int[n][2];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                houses[i] = new int[]{x, y};
            }

            int[][] answers = new int[4][2];
            answers[0] = new int[]{sx+1, sy};
            answers[1] = new int[]{sx-1, sy};
            answers[2] = new int[]{sx, sy+1};
            answers[3] = new int[]{sx, sy-1};

            int maxCount = 0;
            int[] maxAns = new int[2];
            for (int i = 0; i < 4; i++) {
                int[] ans = answers[i];
                int ansX = ans[0];
                int ansY = ans[1];
                int count = 0;
                for (int j = 0; j < n; j++) {
                    int[] house = houses[j];
                    int houseX = house[0];
                    int houseY = house[1];
                    int disSchool = Math.abs(houseX - sx) + Math.abs(houseY - sy);
                    int disTent = Math.abs(houseX - ansX) + Math.abs(houseY - ansY);
                    if (disSchool - disTent == 1) {
                        count++;
                    }
                }

                if (count > maxCount) {
                    maxCount = count;
                    maxAns = ans;
                }
            }
            
            System.out.println(maxCount);
            System.out.print(maxAns[0] + " " + maxAns[1]);
            System.out.println();
        }
    }

}
