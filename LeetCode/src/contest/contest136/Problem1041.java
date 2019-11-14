package contest.contest136;

public class Problem1041 {

    public boolean isRobotBounded(String instructions) {
        char[] arr = instructions.toCharArray();

        int x = 0;
        int y = 0;
        int direction = 0; // 0，1，2，3 上右下左

        int time = 4;

        while ((time--) > 0) {
            for (char c : arr) {
                if (c == 'G') {
                    if (direction == 0) {
                        y++;
                    } else if (direction == 1) {
                        x++;
                    } else if (direction == 2) {
                        y--;
                    } else {
                        x--;
                    }
                } else if (c == 'L') {
                    direction = (direction + 3) % 4;
                } else if (c == 'R') {
                    direction = (direction + 1) % 4;
                }
            }

            if (x == 0 && y == 0 && direction == 0) {
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
