package contest.contest140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1079 {

    private int ans = 0;

    private void backTrack(char[] arr, boolean[] visited, List<Character> tmpList) {
        if (!tmpList.isEmpty()) {
            ans++;
        }

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (visited[i] || (i > 0 && !visited[i-1] && c == arr[i-1])) {
                continue;
            }

            visited[i] = true;
            tmpList.add(c);
            backTrack(arr, visited, tmpList);
            tmpList.remove(tmpList.size() - 1);
            visited[i] = false;
        }
    }

    public int numTilePossibilities(String tiles) {
        int len = tiles.length();
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        backTrack(arr, new boolean[len], new ArrayList<>());
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
