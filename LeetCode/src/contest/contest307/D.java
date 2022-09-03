package contest.contest307;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

    class Data {
        long sum;
        int idx;
        Data(long sum, int idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public long kSum(int[] nums, int k) {
        int len = nums.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
               sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        if (k == 1) {
            return sum;
        }
        Arrays.sort(nums);
        PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                // 子段和从大到小排序
                return Long.compare(o2.sum, o1.sum);
            }
        });
        heap.add(new Data(sum - nums[0], 0));
        for (int i = 2; i < k; i++) {
            Data top = heap.poll();
            if (top.idx < len - 1) {
                heap.add(new Data(top.sum + nums[top.idx] - nums[top.idx + 1], top.idx + 1));
                heap.add(new Data(top.sum - nums[top.idx + 1], top.idx + 1));
            }
        }
        return heap.peek().sum;
    }

}
