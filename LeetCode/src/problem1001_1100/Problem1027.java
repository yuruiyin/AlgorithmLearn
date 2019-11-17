package problem1001_1100;

import java.util.ArrayList;
import java.util.List;

public class Problem1027 {

    // 找到第一个比他大的
    private int binarySearch(List<Integer> indexList, int target) {
        int low = 0;
        int high = indexList.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = indexList.get(mid);
            if (midVal > target) {
                if (mid == 0 || indexList.get(mid - 1)  < target) {
                    return midVal;
                }

                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int longestArithSeqLength(int[] arr) {
        List<Integer>[] indexListArr = new ArrayList[10001];
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (indexListArr[num] == null) {
                indexListArr[num] = new ArrayList<>();
                indexListArr[num].add(i);
            } else {
                indexListArr[num].add(i);
            }
        }

        int max = 2;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = arr[j] - arr[i];
                int nextValue = arr[j] + diff;
                int listLen = 2;
                int curJ = j;
                while (true) {
                    if (nextValue < 0 || nextValue > 10000 || indexListArr[nextValue] == null) {
                        break;
                    }

                    List<Integer> indexList = indexListArr[nextValue];
                    int nextIndex = binarySearch(indexList, curJ);
                    if (nextIndex == - 1) {
                        break;
                    }

                    listLen++;
                    nextValue = arr[nextIndex] + diff;
                    curJ = nextIndex;
                }

                if (listLen > max) {
                    max = listLen;
                }
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem1027().longestArithSeqLength(new int[]{3,6,9,12}));
    }
    
}
