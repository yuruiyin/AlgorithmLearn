package contest.contest263;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/17
 */
public class C {

    private int max = 0;
    private int[] arr;
    private int len;
    private int ansCount = 0;

    private void calcMax(int curIdx, int value) {
        if (curIdx == len) {
            max = Math.max(max, value);
            return;
        }

        calcMax(curIdx + 1, value);
        calcMax(curIdx + 1, value | arr[curIdx]);
    }

    private void calcMax1(int curIdx, int value) {
        if (curIdx == len) {
            if (value == max) {
                ansCount++;
            }
            return;
        }

        calcMax1(curIdx + 1, value);
        calcMax1(curIdx + 1, value | arr[curIdx]);
    }

    public int countMaxOrSubsets(int[] arr) {
        this.arr = arr;
        this.len = arr.length;
        calcMax(0, 0);
        calcMax1(0, 0);
        return ansCount;
    }

}
