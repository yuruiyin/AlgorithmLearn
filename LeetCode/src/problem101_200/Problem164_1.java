package problem101_200;

import java.util.ArrayList;
import java.util.List;

public class Problem164_1 {

    // 利用桶排序和鸽巢定理
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        // 根据鸽巢定理，桶的个数为n+1的时候，把n个数放入桶中，一定会产生一个空桶, 这样就可以确定最大间距出现在相邻桶之间（跳过空桶）
        int bucketCount = len + 1;
        List<Integer>[] bucket = new ArrayList[bucketCount];
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        // 每个桶的大小
        int interval = (int) Math.ceil((max - min) * 1.0 / bucketCount) + 1;

        // 将数组放到各个桶中
        for (int num: nums) {
            int bucketIndex = (num - min) / interval;
            if (bucket[bucketIndex] == null) {
                bucket[bucketIndex] = new ArrayList<>();
            }
            bucket[bucketIndex].add(num);
        }

        //先求第一个桶的最大值
        int prevBucketMax = 0;
        for (Integer num: bucket[0]) {
            prevBucketMax = Math.max(prevBucketMax, num);
        }
        int anxMax = 0;
        for (int i = 1; i < bucketCount; i++) {
            // 求每个桶的最大最小值
            if (bucket[i] == null || bucket[i].isEmpty()) {
                continue;
            }

            int bucketMin = Integer.MAX_VALUE;
            int bucketMax = 0;
            for (Integer num: bucket[i]) {
                bucketMin = Math.min(bucketMin, num);
                bucketMax = Math.max(bucketMax, num);
            }

            int diff = bucketMin - prevBucketMax;
            anxMax = Math.max(anxMax, diff);
            prevBucketMax = bucketMax;
        }

        return anxMax;
    }
    
    public static void main(String[] args) {
//        System.out.println(new Problem164_1().maximumGap(new int[]{3,6,9,1}));
//        System.out.println(new Problem164_1().maximumGap(new int[]{1, 10000000}));
        System.out.println(new Problem164_1().maximumGap(new int[]{15252,16764,27963,7817,26155,20757,3478,22602,
                20404,6739,16790,10588,16521,6644,20880,15632,27078,25463,20124,15728,30042,16604,17223,4388,23646,
                32683,23688,12439,30630,3895,7926,22101,32406,21540,31799,3768,26679,21799,23740}));
    }

}
