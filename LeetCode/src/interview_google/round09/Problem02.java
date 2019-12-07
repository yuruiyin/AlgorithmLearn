package interview_google.round09;

import java.util.*;

public class Problem02 {

    class Data {
        int value;
        List<Integer> indexList;
        Data(int value, List<Integer> indexList) {
            this.value = value;
            this.indexList = indexList;
        }
    }

    class FreqStack {

        private Map<Integer, Integer> countMap;
        private PriorityQueue<Data> priorityQueue;
        private Map<Integer, Data> map;
        private List<Integer> numList;

        public FreqStack() {
            countMap = new HashMap<>();
            map = new HashMap<>();
            numList = new ArrayList<>();
            priorityQueue = new PriorityQueue<>(new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    int count1 = o1.indexList.size();
                    int count2 = o2.indexList.size();
                    if (count1 != count2) {
                        return count2 - count1;
                    }

                    return o2.indexList.get(count2 - 1) - o1.indexList.get(count1 - 1);
                }
            });
        }

        public void push(int x) {
            int xCount = countMap.getOrDefault(x, 0);
            if (xCount == 0) {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(numList.size());
                Data data = new Data(x, indexList);
                priorityQueue.offer(data);
                map.put(x, data);
            } else {
                Data data = map.get(x);
                priorityQueue.remove(data);
                data.indexList.add(numList.size());
                priorityQueue.offer(data);
            }

            countMap.put(x,  xCount + 1);
            numList.add(x);
        }

        public int pop() {
            Data max = priorityQueue.poll();
            max.indexList.remove(max.indexList.size() - 1);
            if (!max.indexList.isEmpty()) {
                priorityQueue.offer(max);
            }
            return max.value;
        }
    }

}
