package contest.contest302;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C_2 {

    class Data {
        char[] arr;
        int idx;
        Data(char[] arr, int idx) {
            this.arr = arr;
            this.idx = idx;
        }
    }

    private int compareTo(char[] arr1, char[] arr2, int trim) {
        int len = arr1.length;
        for (int i = len - trim; i < len; i++) {
            if (arr1[i] < arr2[i]) {
                return -1;
            } else if (arr1[i] > arr2[i]) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * 使用heap优化
     */
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int qLen = queries.length;
        int[] ansArr = new int[qLen];
        Data[] datas = new Data[nums.length];
        for (int i = 0; i < nums.length; i++) {
            datas[i] = new Data(nums[i].toCharArray(), i);
        }

        for (int i = 0; i < qLen; i++) {
            int[] query = queries[i];
            int k = query[0];
            int trim = query[1];
            PriorityQueue<Data> heap = new PriorityQueue<>(k, new Comparator<Data>() {
                @Override
                public int compare(Data o1, Data o2) {
                    int compareRes = compareTo(o1.arr, o2.arr, trim);
                    return compareRes == 0 ? (o2.idx - o1.idx) : -compareRes;
                }
            });

            for (int j = 0; j < nums.length; j++) {
                heap.add(datas[j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
            ansArr[i] = heap.peek().idx;
        }
        return ansArr;
    }

    public static void main(String[] args) {
        System.out.println("0".compareTo("1"));
    }

}
