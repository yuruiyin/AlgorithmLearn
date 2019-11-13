package contest.contest138;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1054 {

    class Data {
        int num;
        int count;
        Data(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        if (len <= 2) {
            return barcodes;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: barcodes) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        PriorityQueue<Data> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for (Integer key: countMap.keySet()) {
            priorityQueue.add(new Data(key, countMap.get(key)));
        }

        int[] ansArr = new int[len];
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            Data data = priorityQueue.poll();
            int num = data.num;
            ansArr[index++] = num;
            data.count--;
            if (data.count == 0) {
                continue;
            }

            if (priorityQueue.isEmpty()) {
                break;
            }

            Data nextData = priorityQueue.poll();
            ansArr[index++] = nextData.num;
            nextData.count--;
            priorityQueue.add(data);
            if (nextData.count > 0) {
                priorityQueue.add(nextData);
            }

        }

        return ansArr;

    }
    
    public static void main(String[] args) {
        
    }
    
}
