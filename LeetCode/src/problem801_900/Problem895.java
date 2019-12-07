package problem801_900;

import java.util.*;

public class Problem895 {

    class Data {
        int value;
        List<Integer> indexList;
        Data(int value, List<Integer> indexList) {
            this.value = value;
            this.indexList = indexList;
        }
    }

    class FreqStack {
        private PriorityQueue<Data> priorityQueue;
        private Map<Integer, Data> map;
        private int stackSize = 0;

        public FreqStack() {
            map = new HashMap<>();
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
            Data data = map.get(x);
            if (data == null || data.indexList.isEmpty()) {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(stackSize);
                Data wantAddedData = new Data(x, indexList);
                priorityQueue.offer(wantAddedData);
                map.put(x, wantAddedData);
            } else {
                priorityQueue.remove(data);
                data.indexList.add(stackSize);
                priorityQueue.offer(data);
            }

            stackSize++;
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
