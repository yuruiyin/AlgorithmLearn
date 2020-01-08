package problem901_1000;

import java.util.ArrayList;
import java.util.List;

public class Problem923 {

    private static final int MOD = 1000000007;

    private int findFirstBigger(List<Integer> list, int target) {
        int size = list.size();
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);
            if (midVal > target) {
                if (mid == 0 || list.get(mid - 1) <= target) {
                    return mid;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int threeSumMulti(int[] arr, int target) {
        int len = arr.length;
        List<Integer>[] indexListArr = new ArrayList[101];

        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (indexListArr[num] == null) {
                indexListArr[num] = new ArrayList<>();
            }

            indexListArr[num].add(i);
        }

        long ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int firstNum = arr[i];
                int secondNum = arr[j];
                int thirdNum = target - firstNum - secondNum;
                if (thirdNum < 0 || thirdNum > 100) {
                    continue;
                }
                List<Integer> thirdNumIndexList = indexListArr[thirdNum];
                if (thirdNumIndexList == null) {
                    continue;
                }

                int thirdFromIndex = findFirstBigger(thirdNumIndexList, j);
                if (thirdFromIndex != -1) {
                    ans = (ans + thirdNumIndexList.size() - thirdFromIndex) % MOD;
                }
            }
        }

        return (int) ans;
    }

}

//        给定一个整数数组 A，以及一个整数 target 作为目标值，返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
//        由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
//
//
//
//        示例 1：
//
//        输入：A = [1,1,2,2,3,3,4,4,5,5], target = 8
//        输出：20
//        解释：
//        按值枚举（A[i]，A[j]，A[k]）：
//        (1, 2, 5) 出现 8 次；
//        (1, 3, 4) 出现 8 次；
//        (2, 2, 4) 出现 2 次；
//        (2, 3, 3) 出现 2 次。
//        示例 2：
//
//        输入：A = [1,1,2,2,2,2], target = 5
//        输出：12
//        解释：
//        A[i] = 1，A[j] = A[k] = 2 出现 12 次：
//        我们从 [1,1] 中选择一个 1，有 2 种情况，
//        从 [2,2,2,2] 中选出两个 2，有 6 种情况。
//
//
//        提示：
//
//        3 <= A.length <= 3000
//        0 <= A[i] <= 100
//        0 <= target <= 300
