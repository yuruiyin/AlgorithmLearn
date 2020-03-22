import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LintCode121
 *
 * @author: yry
 * @date: 2020/3/20
 */
public class LintCode121 {

    private Set<String> startSet;
    private Set<String> endSet;
    private Set<String> dict;

    private int bfs(Set<String> dict) {
        // bfs求最短路
        int level = 1;
        while (!startSet.isEmpty()) {
            Set<String> nextStartSet = new HashSet<>();
            level++;
            for (String word : startSet) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char tmp = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (tmp == c) {
                            continue;
                        }

                        arr[i] = c;
                        String newWord = new String(arr);
                        if (!dict.contains(newWord)) {
                            continue;
                        }

                        if (startSet.contains(newWord)) {
                            continue;
                        }

                        if (endSet.contains(newWord)) {
                            return level;
                        }

                        nextStartSet.add(newWord);
                    }

                    arr[i] = tmp;
                }
            }
            dict.removeAll(startSet);
            startSet = nextStartSet;
        }

        return -1;
    }

    private void dfs(List<List<String>> ansList, int minLevel, List<String> path, String end) {
        if (path.size() == minLevel) {
            if (path.get(path.size() - 1).equals(end)) {
                ansList.add(new ArrayList<>(path));
            }
            return;
        }

        String word = path.get(path.size() - 1);
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (arr[i] == c) {
                    continue;
                }

                arr[i] = c;
                String newWord = new String(arr);
                if (!dict.contains(newWord)) {
                    continue;
                }

                if (startSet.contains(newWord)) {
                    continue;
                }

                path.add(newWord);
                dfs(ansList, minLevel, path, end);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> ansList = new ArrayList<>();

        if (start.equals(end)) {
            List<String> list = new ArrayList<>();
            list.add(start);
            ansList.add(list);
            return ansList;
        }

        startSet = new HashSet<>();
        startSet.add(start);

        endSet = new HashSet<>();
        endSet.add(end);
        this.dict = dict;

        int minLevel = bfs(new HashSet<>(dict)); // copy一份新的，里头会修改dict
        if (minLevel == -1) {
            return ansList;
        }

        List<String> pathList = new ArrayList<>();
        pathList.add(start);
        dfs(ansList, minLevel, pathList, end);

        return ansList;
    }

}
