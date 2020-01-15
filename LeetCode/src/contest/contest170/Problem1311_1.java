package contest.contest170;

import java.util.*;

public class Problem1311_1 {

    class Data {
        String v;
        int count;
        Data(String v, int count) {
            this.v = v;
            this.count = count;
        }
    }

    private List<Integer>[] adj;
    private int level;
    private int[] minLevelArr;
    
    private void backTrack(int from, int lv, boolean[] visited) {
        if (lv > level) {
            return;
        }

        if (lv >= minLevelArr[from]) {
            return;
        }

        minLevelArr[from] = lv;
        visited[from] = true;
        for (Integer next: adj[from]) {
            if (visited[next]) {
                continue;
            }

            backTrack(next, lv+1, visited);
        }

        visited[from] = false;
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = watchedVideos.size();
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < friends.length; i++) {
            for (int f: friends[i]) {
                adj[i].add(f);
            }
        }

        this.level = level;
        minLevelArr = new int[n];
        Arrays.fill(minLevelArr, Integer.MAX_VALUE);
        backTrack(id, 0, new boolean[n]);

        List<Integer> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (minLevelArr[i] == level) {
                personList.add(i);
            }
        }

        Map<String, Integer> countMap = new HashMap<>();

        List<String> ansList = new ArrayList<>();
        for (Integer person : personList) {
            for (String v : watchedVideos.get(person)) {
                countMap.put(v, countMap.getOrDefault(v, 0) + 1);
            }
        }

        List<Data> dataList = new ArrayList<>();

        for (String v : countMap.keySet()) {
            dataList.add(new Data(v, countMap.get(v)));
        }

        dataList.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if (o1.count == o2.count) {
                    return o1.v.compareTo(o2.v);
                }

                return o1.count - o2.count;
            }
        });

        for (Data data :dataList) {
            ansList.add(data.v);
        }

        return ansList;

    }

}
