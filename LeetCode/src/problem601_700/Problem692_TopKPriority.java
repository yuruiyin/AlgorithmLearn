package problem601_700;

import utils.TopKPriorityQueue;

import java.util.*;

public class Problem692_TopKPriority {

    class Data implements Comparable<Data> {
        String word;
        int count;
        Data(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(Data o) {
            if (this.count != o.count) {
                return o.count - this.count;
            }
            return this.word.compareTo(o.word);
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

        TopKPriorityQueue<Data> priorityQueue = new TopKPriorityQueue<>(k);

        for (String word: countMap.keySet()) {
            priorityQueue.add(new Data(word, countMap.get(word)));
        }

        List<String> ansList = new ArrayList<>();
        List<Data> dataList = priorityQueue.sortedList();
        for (Data data: dataList) {
            ansList.add(data.word);
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem692_TopKPriority().topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding",
        }, 2);

        for (String word: ansList) {
            System.out.print(word + ",");
        }

        System.out.println();
    }


}
