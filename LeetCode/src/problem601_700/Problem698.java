package problem601_700;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem698 {

    private int[] nums;
    private int eachSum;
    private int len;
    private Map<String, Boolean> memoMap;

    private int getNeedAddCount(short[] indexArr) {
        int count = 0;
        for (short index : indexArr) {
            int sum = getSum(index);
            if (sum != eachSum) {
                count++;
            }
        }
        return count;
    }

    private String convert(short[] indexArr) {
        StringBuilder sb = new StringBuilder();
        for (short index : indexArr) {
            sb.append(index).append(',');
        }
        return sb.toString();
    }

    private int getSum(short index) {
        int sum = 0;
        for (int i = 0; i < len && index > 0; i++) {
            if (index % 2 == 1) {
                sum += nums[i];
            }
            index >>>= 1;
        }
        return sum;
    }

    private boolean rec(short[] indexArr, int idx) {
        if (idx == len) {
            return true;
        }

//        String key = convert(indexArr);
//        if (memoMap.containsKey(key)) {
//            return memoMap.get(key);
//        }

        if (getNeedAddCount(indexArr) > len - idx) {
            // 后面的数个数太少了，已经不够填了
//            memoMap.put(key, false);
            return false;
        }

        // 将当前idx放到加载任意个集合中
        for (int i = 0; i < indexArr.length; i++) {
            int sum = getSum(indexArr[i]);
            if (sum + nums[idx] > eachSum) {
                continue;
            }
            indexArr[i] |= (1 << idx);
            boolean isOk = rec(indexArr, idx + 1);
            if (isOk) {
//                memoMap.put(key, true);
                return true;
            }
            indexArr[i] ^= (1 << idx);
        }
//        memoMap.put(key, false);
        return false;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }

        this.eachSum = sum / k;
        this.nums = nums;
        this.len = nums.length;
        memoMap = new HashMap<>();
        return rec(new short[k], 0);
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Problem698().canPartitionKSubsets(new int[]{
                3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269
        }, 5));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

}
