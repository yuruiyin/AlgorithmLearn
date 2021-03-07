package contest.contest226;

/**
 * A
 *
 * @author: yry
 * @date: 2021/1/31
 */
public class A {

    public int countBalls(int lowLimit, int highLimit) {
        int[] countArr = new int[50];
        for (int i = lowLimit; i <= highLimit; i++) {
            char[] arr = String.valueOf(i).toCharArray();
            int sum = 0;
            for (char c : arr) {
                sum += (c - '0');
            }
            countArr[sum]++;
        }

        int max = 0;
        for (int i = 0; i < 50; i++) {
            max = Math.max(max, countArr[i]);
        }
        return max;
    }

}
