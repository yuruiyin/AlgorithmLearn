package contest.contest186;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class A_1 {

    public int maxScore(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int totalOneCount = 0;
        for (char c : arr) {
            if (c == '1') {
                totalOneCount++;
            }
        }

        int leftZeroCount = 0;
        int ansMax = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == '0') {
                leftZeroCount++;
            }
            int rightOneCount = totalOneCount - (i + 1 - leftZeroCount);
            ansMax = Math.max(ansMax, leftZeroCount + rightOneCount);
        }
        return ansMax;
    }

}
