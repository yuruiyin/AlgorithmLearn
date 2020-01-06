package contest.contest170;

import java.util.*;

public class Problem03 {

    class Data {
        String v;
        int count;
        Data(String v, int count) {
            this.v = v;
            this.count = count;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // BFS
        int n = watchedVideos.size();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        boolean[] visited = new boolean[n];
        visited[id] = true;

        int curLevel = 0;

        List<Integer> personList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            curLevel++;
            personList.clear();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int next: friends[cur]) {
                    if (visited[next]) {
                        continue;
                    }

                    personList.add(next);
                    visited[next] = true;
                    queue.offer(next);
                }
            }

            if (curLevel == level) {
                break;
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

    public static void main(String[] args) {

    }

}
