package problem301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem347 {

    class Data {
        int num;
        int count;
        Data(int num, int count) {
            this.num = num;
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
            if (2*i+1 < k && datas[2*i+1].count < datas[minPos].count) {
                minPos = 2*i+1;
            }

            if (2*i+2 < k && datas[2*i+2].count < datas[minPos].count) {
                minPos = 2*i+2;
            }

            if (minPos == i) {
                break;
            }

            swap(datas, i, minPos);
            i = minPos;
        }
    }

    /**
     * 构建一个小顶堆
     */
    private void buildHeap(Data[] datas, int k) {
        for (int i = (k - 1) / 2; i >= 0; i--) {
            heapify(datas, i, k);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num: nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        int size = countMap.keySet().size();
        Data[] datas = new Data[size];
        int count = 0;

        for (Integer key : countMap.keySet()) {
            datas[count++] = new Data(key, countMap.get(key));
        }

        //建堆
        buildHeap(datas, k);
        // 从第k+1个开始一个个与小顶堆堆顶进行对比，比他大，则替换，然后堆化
        for (int i = k; i < count; i++) {
            if (datas[i].count > datas[0].count) {
                swap(datas, 0, i);
                heapify(datas, 0, k);
            }
        }

        // 最后datas前k个元素就是出现频率前k高的元素
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ansList.add(datas[i].num);
        }

        return ansList;
    }
    
    public static void main(String[] args) {
//        List<Integer> ansList = new Problem347().topKFrequent(new int[]{1,1,1,2,2,3}, 2);
        List<Integer> ansList = new Problem347().topKFrequent(new int[]{1}, 1);

        for (Integer num: ansList) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
    
}
