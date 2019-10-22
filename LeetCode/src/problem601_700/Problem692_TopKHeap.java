package problem601_700;

import java.util.*;

/**
 * 自定义堆的方式 O(n*logk)
 */
public class Problem692_TopKHeap {

    class Data {
        String word;
        int count;
        Data(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    private void swap(Data[] datas, int i, int j) {
        Data tmp = datas[i];
        datas[i] = datas[j];
        datas[j] = tmp;
    }

    private void heapify(Data[] datas, int i, int k) {
        while (true) {
            int minPos = i;
            if (2*i+1 < k) {
                if (datas[2*i+1].count < datas[minPos].count ||
                        datas[2*i+1].count == datas[minPos].count && datas[2*i+1].word.compareTo(datas[minPos].word) > 0) {
                    minPos = 2*i+1;
                }
            }

            if (2*i+2 < k) {
                if (datas[2*i+2].count < datas[minPos].count ||
                        datas[2*i+2].count == datas[minPos].count && datas[2*i+2].word.compareTo(datas[minPos].word) > 0) {
                    minPos = 2*i+2;
                }
            }

            if (minPos == i) {
                break;
            }

            swap(datas, i, minPos);
            i = minPos;
        }
    }

    private void buildHeap(Data[] datas, int k) {
        //从第一个不是叶子节点开始
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(datas, i, k);
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

        int wordCount = countMap.keySet().size();

        Data[] datas = new Data[wordCount];
        int num = 0;
        for (String word: countMap.keySet()) {
            datas[num++] = new Data(word, countMap.get(word));
        }

        // 建堆,大小为k
        buildHeap(datas, k);
        // 遍历第k到n个元素，逐个与小顶堆堆顶进行比较
        for (int i = k; i < wordCount; i++) {
            if (datas[i].count > datas[0].count ||
                    datas[i].count == datas[0].count && datas[i].word.compareTo(datas[0].word) < 0) {
                // count大于堆顶或者count相等，而且单词字母顺序更小，替换
                swap(datas, i, 0);
                heapify(datas, 0, k);
            }
        }

        // 对小顶堆进行排序
        Arrays.sort(datas, 0, k, new CustomCmp());
        List<String> ansList = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ansList.add(datas[i].word);
        }

        return ansList;
    }

    public static void main(String[] args) {
        List<String> ansList = new Problem692_TopKHeap().topKFrequent(new String[]{
                "i", "love", "leetcode", "i", "love", "coding",
        }, 2);

        for (String word: ansList) {
            System.out.print(word + ",");
        }

        System.out.println();
    }

}
