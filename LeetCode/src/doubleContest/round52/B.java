package doubleContest.round52;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/15
 */
public class B {

    public int[] memLeak(int memory1, int memory2) {
        int[] ansArr = new int[3];

        for (int i = 1; ;i++) {
            int max = Math.max(memory1, memory2);
            if (i > max) {
                ansArr[0] = i;
                ansArr[1] = memory1;
                ansArr[2] = memory2;
                break;
            }

            if (memory1 == memory2) {
                memory1 -= i;
            } else if (memory1 > memory2) {
                memory1 -= i;
            } else {
                memory2 -= i;
            }
        }

        return ansArr;
    }

}
