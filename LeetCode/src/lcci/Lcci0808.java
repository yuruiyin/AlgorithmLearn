package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lcci0808 {

    private char[] arr;
    private int len;
    private List<String> ansList;

    private void backTrack(boolean[] visited, StringBuilder tmpSb) {
        if (tmpSb.length() == len) {
            ansList.add(tmpSb.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i] || i > 0 && !visited[i-1] && arr[i] == arr[i-1]) {
                continue;
            }

            visited[i] = true;
            tmpSb.append(arr[i]);
            backTrack(visited, tmpSb);
            tmpSb.deleteCharAt(tmpSb.length() - 1);
            visited[i] = false;
        }
    }

    public String[] permutation(String str) {
        arr = str.toCharArray();
        len = arr.length;
        Arrays.sort(arr);
        ansList = new ArrayList<>();
        backTrack(new boolean[len], new StringBuilder());
        String[] ansArr = new String[ansList.size()];
        return ansList.toArray(ansArr);
    }

}
