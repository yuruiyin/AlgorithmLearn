package lcp;

public class Problem03 {

    private boolean isMeet(char[] commandArr, int targetX, int targetY) {
        int x = 0;
        int y = 0;
        for (char c : commandArr) {
            if (c == 'U') {
                y++;
            } else {
                x++;
            }

            if (x == targetX && y == targetY) {
                return true;
            }
        }

        return false;
    }

    public boolean robot(String command, int[][] obstacles, int x, int y) {
        int uCount = 0;
        int rCount = 0;
        char[] commandArr = command.toCharArray();

        for (char c: commandArr) {
            if (c == 'U') {
                uCount++;
            } else {
                rCount++;
            }
        }

        for (int[] obstacle: obstacles) {
            int tmpX = obstacle[0];
            int tmpY = obstacle[1];
            if (tmpX > x || tmpY > y) {
                continue;
            }

            // 判断是否会到达障碍物
            if (tmpX >= rCount && tmpY >= uCount) {
                int min = Math.min(tmpX / rCount, tmpY / uCount);
                tmpX = tmpX - rCount * min;
                tmpY = tmpY - uCount * min;
            }

            if (tmpX == 0 && tmpY == 0) {
                return false;
            }

            if (isMeet(commandArr, tmpX, tmpY)) {
                return false;
            }
        }

        if (x >= rCount && y >= uCount) {
            int min = Math.min(x / rCount, y / uCount);
            x = x - rCount * min;
            y = y - uCount * min;
        }

        if (x == 0 && y == 0) {
            return true;
        }

        return isMeet(commandArr, x, y);
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem03().robot("URRURRR", new int[][]{
//                {7, 7}, {0, 5}, {2, 7}, {8, 6}, {8, 7}, {6, 5}, {4, 4}, {0, 3}, {3, 6}
//        }, 4915, 1966));

        System.out.println(new Problem03().robot("UUR", new int[][]{
                {10, 3}, {8, 7}, {8, 9}, {7, 9}, {4, 7}, {0, 2}, {8, 0}, {5, 2}, {1, 9}
        }, 410, 820));
    }

}
