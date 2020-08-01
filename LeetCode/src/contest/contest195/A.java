package contest.contest195;

import java.util.HashSet;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/30
 */
public class A {

    public boolean isPathCrossing(String path) {
        char[] arr = path.toCharArray();
        Set<Integer> visited = new HashSet<>();
        // path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
        int x = 0;
        int y = 0;
        visited.add(0);
        for (char c : arr) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else {
                x--;
            }

            int key = x * 10000 + y;
            if (visited.contains(key)) {
                return true;
            }

            visited.add(key);
        }

        return false;
    }

}
