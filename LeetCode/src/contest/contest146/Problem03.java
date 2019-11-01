package contest.contest146;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem03 {

    class CustomCmp implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        if (len == 2) {
            return arr[0] * arr[1];
        }

        int ans = 0;

        if (arr[0] * arr[1] < arr[len - 2] * arr[len - 1]) {
            // 从左往右
            ans += arr[0] * arr[1];
            PriorityQueue<Integer> bigRootQueue = new PriorityQueue<>(new CustomCmp());
            bigRootQueue.add(arr[0]);
            bigRootQueue.add(arr[1]);
            for (int i = 2; i < len; ) {
                int queueMax = bigRootQueue.peek();
                if (i < len - 1 && queueMax < arr[i+1]) {
                    ans += arr[i] * arr[i+1];
                    ans += Math.max(arr[i], arr[i+1]) * queueMax;
                    bigRootQueue.add(arr[i]);
                    bigRootQueue.add(arr[i+1]);
                    i += 2;
                } else {
                    ans += queueMax * arr[i];
                    bigRootQueue.add(arr[i]);
                    i++;
                }
            }
        } else {
            // 从左往右
            ans += arr[len - 2] * arr[len - 1];
            PriorityQueue<Integer> bigRootQueue = new PriorityQueue<>(new CustomCmp());
            bigRootQueue.add(arr[len - 2]);
            bigRootQueue.add(arr[len - 1]);
            for (int i = len - 3; i >= 0; ) {
                int queueMax = bigRootQueue.peek();
                if (i > 0 && queueMax < arr[i-1]) {
                    ans += arr[i] * arr[i-1];
                    ans += Math.max(arr[i], arr[i-1]) * queueMax;
                    bigRootQueue.add(arr[i]);
                    bigRootQueue.add(arr[i-1]);
                    i -= 2;
                } else {
                    ans += queueMax * arr[i];
                    bigRootQueue.add(arr[i]);
                    i--;
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        
    }
    
}
