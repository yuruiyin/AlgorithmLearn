package problem301_400;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem365
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class Problem365 {
    private int capX;
    private int capY;
    private int z;
    private boolean isFound = false;
    private Set<Long> visited;

    private boolean dfs(int x, int y) {
        if (isFound) {
            return true;
        }
        // 可以将其中一个水壶中的水倒满、倒空、或者一个水壶往另外一个水壶倒水，直到倒满或倒空
        if (x == z || y == z || x + y == z) {
            isFound = true;
            return true;
        }

        long key = x * (capY + 1L) + y;
        if (visited.contains(key)) {
            return false;
        }

        visited.add(key);

        // 只处理第一个水壶
        boolean res1 = false;
        if (x == 0) {
            res1 = dfs(capX, y);
        } else if (x < capX) {
            res1 = dfs(capX, y);
            if (res1) {
                isFound = true;
                return true;
            }
            res1 = dfs(0, y);
        } else if (x == capX) {
            res1 = dfs(0, y);
        }

        if (res1) {
            isFound = true;
            return true;
        }

        // 只处理第二个水壶
        boolean res2 = false;
        if (y == 0) {
            res2 = dfs(x, capY);
        } else if (y < capY) {
            res2 = dfs(x, capY);
            if (res2) {
                isFound = true;
                return true;
            }
            res2 = dfs(x, 0);
        } else if (y == capY) {
            res2 = dfs(x, 0);
        }

        if (res2) {
            isFound = true;
            return true;
        }

        // 第一个水壶往第二个水壶倒水
        boolean res3 = false;
        if (x > 0 && y != capY) {
            int nextX = x;
            int nextY = y;
            if (capY - y >= x) {
                nextX = 0;
                nextY += x;
            } else {
                nextX = x - (capY - y);
                nextY = capY;
            }
            res3 = dfs(nextX, nextY);
        }

        if (res3) {
            isFound = true;
            return true;
        }

        // 第二个水壶往第一个水壶倒水
        boolean res4 = false;
        if (x != capX && y > 0) {
            int nextX = x;
            int nextY = y;
            if (capX - x >= y) {
                nextX += y;
                nextY = 0;
            } else {
                nextX = capX;
                nextY = y - (capX - x);
            }
            res4 = dfs(nextX, nextY);
        }

        isFound = res4;
        return isFound;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y || z == 0) {
            return true;
        }

        if (x + y < z || x == y && x + y != z) {
            return false;
        }

        capX = x;
        capY = y;
        this.z = z;
        visited = new HashSet<>();
        return dfs(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Problem365().canMeasureWater(3, 5, 4));
    }

}
