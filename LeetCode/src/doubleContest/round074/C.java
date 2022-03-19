package doubleContest.round074;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * A
 *
 * @author: yry
 * @date: 2022/3/19
 */
public class C {

    public int halveArray(int[] nums) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }

        double[] arr = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        PriorityQueue<Double> heap = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o2, o1);
            }
        });

        for (double num : arr) {
            heap.add(num);
        }

        int ans = 0;
        double curSum = sum;
        while (curSum > sum / 2) {
            double curMax = heap.poll();
            curMax = curMax / 2;
            curSum -= curMax;
            heap.add(curMax);
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
