package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcof038 {

    private List<String> ansList;
    private char[] arr;
    private int len;

    private void backTrack(int idx, boolean[] visited, StringBuilder tmpSb) {
        if (idx == len) {
            ansList.add(tmpSb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || i > 0 && !visited[i-1] && arr[i] == arr[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpSb.append(arr[i]);
            backTrack(idx + 1, visited, tmpSb);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
            visited[i] = false;
        }
    }

    public String[] permutation(String s) {
        arr = s.toCharArray();
        Arrays.sort(arr);
        len = arr.length;
        ansList = new ArrayList<>();
        backTrack(0, new boolean[len], new StringBuilder());

        int size = ansList.size();
        String[] ans = new String[size];
        for (int i = 0; i < size; i++) {
            ans[i] = ansList.get(i);
        }
        return ans;
    }

}
