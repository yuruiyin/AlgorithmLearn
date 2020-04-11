package problem801_900;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem821
 *
 * @author: yry
 * @date: 2020/4/11
 */
public class Problem821 {

    public int[] shortestToChar(String str, char c) {
        List<Integer> indexList = new ArrayList<>();
        char[] arr = str.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == c) {
                indexList.add(i);
            }
        }

        int size = indexList.size();
        int[] ansArr = new int[len];
        int firstIndex = indexList.get(0);
        for (int i = 0; i < firstIndex; i++) {
            ansArr[i] = firstIndex - i;
        }

        int lastIndex = indexList.get(size - 1);
        for (int i = len - 1; i > lastIndex; i--) {
            ansArr[i] = i - lastIndex;
        }

        for (int i = 0; i < size - 1; i++) {
            // 左一半跟左边那个比，右一半跟右边那个比
            int curIndex = indexList.get(i);
            int nextIndex = indexList.get(i + 1);
            int mid = (curIndex + nextIndex) >>> 1;
            ansArr[curIndex] = 0;
            for (int j = curIndex + 1; j <= mid; j++) {
                ansArr[j] = j - curIndex;
            }

            for (int j = mid + 1; j < nextIndex; j++) {
                ansArr[j] = nextIndex - j;
            }
        }

        ansArr[indexList.get(size - 1)] = 0;
        return ansArr;
    }

}
