package fall_2021;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/11
 */
public class D {

    private boolean isIn(long toyX, long toyY, long toyR, long cx, long cy, long cr) {
        if (toyR > cr) {
            return false;
        }
        long dis = (cx - toyX) * (cx - toyX) + (cy - toyY) * (cy - toyY);
        return dis <= (cr - toyR) * (cr - toyR);
    }

    private boolean isOk(int[] toy, Map<Long, int[]> map, int r) {
        int tx = toy[0];
        int ty = toy[1];
        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                int needx = tx + x;
                int needy = ty + y;
                long key = (long) (needx * (1e9 + 1L) + needy);
                int[] circle = map.get(key);
                if (circle == null) {
                    continue;
                }

                int cx = circle[0];
                int cy = circle[1];
                if (isIn(toy[0], toy[1], toy[2], cx, cy, r)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int circleGame(int[][] toys, int[][] circles, int r) {
        boolean[] isInArr = new boolean[toys.length];
        Map<Long, int[]> map = new HashMap<>();
        for (int[] circle : circles) {
            int cx = circle[0];
            int cy = circle[1];
            map.put((long) (cx * (1e9 + 1L) + cy), circle);
        }

        for (int i = 0; i < toys.length; i++) {
            int[] toy = toys[i];
            if (isOk(toy, map, r)) {
                isInArr[i] = true;
            }
        }

        int ans = 0;
        for (int i = 0; i < toys.length; i++) {
            if (isInArr[i]) {
                ans++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {

    }

}
