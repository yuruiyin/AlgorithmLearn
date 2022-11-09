package contest.contest317;

import java.util.*;

public class B {

    class Data {
        String id;
        int viewCount;
        Data(String id, int viewCount) {
            this.id = id;
            this.viewCount = viewCount;
        }
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int len = creators.length;
        int max = 0;
        Map<String, Long> viewCountMap = new HashMap<>();
        Map<String, PriorityQueue<Data>> map = new HashMap<>();
        List<List<String>> ansList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!viewCountMap.containsKey(creators[i])) {
                viewCountMap.put(creators[i], (long) views[i]);
            } else {
                viewCountMap.put(creators[i], viewCountMap.getOrDefault(creators[i], 0L) + (long)views[i]);
            }
            if (!map.containsKey(creators[i])) {
                map.put(creators[i], new PriorityQueue<>(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.viewCount == o2.viewCount ? o1.id.compareTo(o2.id) : o2.viewCount - o1.viewCount;
                    }
                }));
            }
            PriorityQueue<Data> heap = map.get(creators[i]);
            heap.add(new Data(ids[i], views[i]));
        }

        long maxCount = 0;
        for (String creator : viewCountMap.keySet()) {
            long count = viewCountMap.get(creator);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        List<String> ansCreators = new ArrayList<>();
        for (String creator : viewCountMap.keySet()) {
            long count = viewCountMap.get(creator);
            if (count == maxCount) {
                ansCreators.add(creator);
            }
        }

        for (String creator : ansCreators) {
            PriorityQueue<Data> heap = map.get(creator);
            List<String> list = new ArrayList<>();
            Data data = heap.peek();
            list.add(creator);
            list.add(data.id);
            ansList.add(list);
        }
        return ansList;
    }

}
