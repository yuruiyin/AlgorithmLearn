package problem301_400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Problem365_bfs
 *
 * @author: yry
 * @date: 2020/3/21
 */
public class Problem365_bfs {

    private LinkedList<int[]> queue;
    private Set<Long> visited;
    private int capY;

    private void handle(int x, int y) {
        long key = x * (capY + 1L) + y;
        if (!visited.contains(key)) {
            queue.offer(new int[]{x, y});
            visited.add(key);
        }
    }

    private boolean bfs(int capX, int capY, int z) {
        this.capY = capY;
        queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited = new HashSet<>();
        visited.add(0L);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int curX = node[0];
                int curY = node[1];

                if (curX + curY == z || curX == z || curY == z) {
                    return true;
                }

                // 水壶1装满
                handle(capX, curY);
                // 水壶1清空
                handle(0, curY);
                // 水壶2装满
                handle(curX, capY);
                // 水壶2清空
                handle(curX, 0);
                // 水壶1往水壶2倒
                int diff1 = Integer.min(curX, capY - curY);
                handle(curX - diff1, curY + diff1);
                // 水壶2往水壶1倒
                int diff2 = Integer.min(curY, capX - curX);
                handle(curX + diff2, curY - diff2);
            }
        }

        return false;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == x || z == y || z == 0) {
            return true;
        }

        if (x + y < z || x == y && x + y != z) {
            return false;
        }

        return bfs(x, y, z);
    }

    public static void main(String[] args) {
        System.out.println(new Problem365_bfs().canMeasureWater(3 ,5, 4));
        System.out.println(new Problem365_bfs().canMeasureWater(2 ,6, 5));
    }

}
