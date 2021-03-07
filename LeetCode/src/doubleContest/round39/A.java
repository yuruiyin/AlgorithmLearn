package doubleContest.round39;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/14
 */
public class A {

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] ansArr = new int[len];

        if (k > 0) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = (i + 1) % len, count = 0; j < len && count < k; j = (j + 1) % len, count++) {
                    sum += code[j];
                }
                ansArr[i] = sum;
            }
        } else if (k < 0) {
            k = -k;
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = (i + len - 1) % len, count = 0; j >= 0 && count < k; j = (j + len - 1) % len, count++) {
                    sum += code[j];
                }
                ansArr[i] = sum;
            }
        }

        return ansArr;
    }

}
