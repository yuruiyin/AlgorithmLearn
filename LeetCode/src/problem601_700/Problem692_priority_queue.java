package problem601_700;

import java.util.*;

public class Problem692_priority_queue {

    class Data {
        String word;
        int count;
        Data(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    class CustomCmp implements Comparator<Data> {

        @Override
        public int compare(Data o1, Data o2) {
            if (o1.count != o2.count) {
                return o1.count - o2.count;
            }
            return o2.word.compareTo(o1.word);
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countMap = new HashMap<>();

        for (String word: words) {
            if (countMap.containsKey(word)) {
                countMap.put(word, countMap.get(word) + 1);
            } else {
                countMap.put(word, 1);
            }
        }

        // 小顶堆
        Queue<Data> priorityQueue = new PriorityQueue<>(k, new CustomCmp());

        for (String word: countMap.keySet()) {
            priorityQueue.add(new Data(word, countMap.get(word)));
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<String> ansList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ansList.add(priorityQueue.poll().word);
        }

        Collections.reverse(ansList);

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem692_priority_queue().topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding",
        }, 2);

        for (String word: ansList) {
            System.out.print(word + ",");
        }

        System.out.println();
    }

}
