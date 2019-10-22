package problem601_700;

import java.util.*;

public class Problem692_sort {

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
                return o2.count - o1.count;
            }

            return o1.word.compareTo(o2.word);
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

        List<Data> dataList = new ArrayList<>();

        for (String word: countMap.keySet()) {
            dataList.add(new Data(word, countMap.get(word)));
        }

        dataList.sort(new CustomCmp());

        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ansList.add(dataList.get(i).word);
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem692_sort().topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding",
        }, 2);

        for (String word: ansList) {
            System.out.print(word + ",");
        }

        System.out.println();
    }

}
