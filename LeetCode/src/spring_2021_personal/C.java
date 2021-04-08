package spring_2021_personal;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/5
 */
public class C {

    public int magicTower(int[] nums) {
        int len = nums.length;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }

        if (len == 1) {
            return 0;
        }

        long pre = 0;
        int ans = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < len; i++) {
            heap.offer(nums[i]);
            pre += nums[i];
            if (pre < 0) {
                int min = heap.poll();
                pre -= min;
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new C().magicTower(new int[]{100,100,100,-250,-60,-140,-50,-50,100,150}));
    }

}
