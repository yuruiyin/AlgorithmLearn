package doubleContest.round43;

import java.util.Arrays;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/9
 */
public class C {

    private int len;
    private int n;

    private int[] maxArr;

    private boolean rec1(int idx, int[] tmpArr, boolean[] visited) {
        if (idx == len - 1) {
            if (tmpArr[idx] == 0) {
                if (visited[1]) {
                    return false;
                }
                tmpArr[idx] = 1;
            }
            maxArr = Arrays.copyOf(tmpArr, len);
            return true;
        }

        if (tmpArr[idx] != 0) {
            return rec1(idx + 1, tmpArr, visited);
        }

        for (int i = n; i >= 1; i--) {
            if (visited[i] || (i != 1 && idx + i >= len)) {
                continue;
            }

            if (i == 1) {
                tmpArr[idx] = 1;
                visited[i] = true;
                boolean isFound = rec1(idx + 1, tmpArr, visited);
                if (isFound) {
                    return true;
                }
                tmpArr[idx] = 0;
                visited[i] = false;
            } else {
                if (tmpArr[idx + i] != 0) {
                    continue;
                }
                tmpArr[idx] = i;
                tmpArr[idx + i] = i;
                visited[i] = true;
                boolean isFound = rec1(idx + 1, tmpArr, visited);
                if (isFound) {
                    return true;
                }
                tmpArr[idx] = 0;
                tmpArr[idx + i] = 0;
                visited[i] = false;
            }

        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        this.len = 2 * n - 1;
        this.n = n;
        maxArr = new int[len];
        rec1(0, new int[len], new boolean[n + 1]);
        return maxArr;
    }

}
