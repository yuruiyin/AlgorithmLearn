package contest.contest217;

import utils.PrintUtil;
import utils.TreeMultiSet;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/29
 */
public class B {

    class Data {
        int val;
        int idx;
        Data(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] mostCompetitive(int[] nums, int k) {
        Map<Integer, List<Integer>> indexListMap = new TreeMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!indexListMap.containsKey(nums[i])) {
                indexListMap.put(nums[i], new ArrayList<>());
            }
            indexListMap.get(nums[i]).add(i);
        }

        int oldK = k;
        int[] ansArr = new int[k];

        TreeMultiSet<Data> treeMultiSet = new TreeMultiSet<>(Comparator.comparingInt(o -> o.val));

        for (int num : indexListMap.keySet()) {
            List<Integer> indexList = indexListMap.get(num);
            int curIdx = indexList.get(0);
            k = oldK;
            if (len - curIdx + 1 < k) {
                continue;
            }

            ansArr[0] = num;
            k--;
            int size = 1;
            int lastEnd = curIdx;
            curIdx++;

            while (k > 0 && len - curIdx + 1 >= k) {
                int curEnd = len - k;
                for (int i = lastEnd + 1; i <= curEnd; i++) {
                    treeMultiSet.add(new Data(nums[i], i));
                }

                if (treeMultiSet.isEmpty()) {
                    break;
                }

                Data minData = treeMultiSet.pollFirst();
                int minIdx = minData.idx;

                ansArr[size++] = minData.val;
                curIdx = minData.idx + 1;
                k--;
                lastEnd = curEnd;
            }

            if (k == 0) {
                return ansArr;
            }
        }

        return null;
    }
    
    public static void main(String[] args) {
        int[] ansArr = new B().mostCompetitive(new int[]{50,100,38,1}, 3);
        PrintUtil.printIntArray(ansArr);
    }

}
