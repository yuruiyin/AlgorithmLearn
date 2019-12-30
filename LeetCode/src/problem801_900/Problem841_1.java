package problem801_900;

import java.util.ArrayList;
import java.util.List;

public class Problem841_1 {

    private boolean[] visited;
    private List<List<Integer>> rooms;

    private void dfs(List<Integer> keyList) {
        if (keyList.isEmpty()) {
            return;
        }
        List<Integer> nextKeyList = new ArrayList<>();
        for (Integer key : keyList) {
            if (visited[key]) {
                continue;
            }

            visited[key] = true;
            nextKeyList.addAll(rooms.get(key));
        }
        dfs(nextKeyList);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        int len = rooms.size();
        List<Integer> keyList = rooms.get(0);
        visited = new boolean[len];
        visited[0] = true;
        dfs(keyList);

        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

}
