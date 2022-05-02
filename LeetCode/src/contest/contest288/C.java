package contest.contest288;

import java.util.Comparator;
import java.util.PriorityQueue;

public class C {

    private static final long MOD = (int) (1e9+7);

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o));

        for (int num : nums) {
            heap.add(num);
        }

        while ((k--) > 0) {
            int min = heap.poll();
            heap.add(min + 1);
        }

        long ans = 1;
        while (!heap.isEmpty()) {
            ans = (int) ((ans * heap.poll()) % MOD);
        }

        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        //[0,4], k = 5
        System.out.println(new C().maximumProduct(new int[]{0,4}, 5));
        System.out.println("hello world");
    }

}
