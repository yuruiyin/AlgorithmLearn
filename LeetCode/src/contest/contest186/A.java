package contest.contest186;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/26
 */
public class A {

    public int maxScore(String s) {
        int[] countArr = new int[2];
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (char c : s.toCharArray()) {
            countArr[c - '0']++;
        }

        int zeroCount = countArr[0];
        int oneCount = countArr[1];

        int max = 0;
        int leftZeroCount = 0;
        int leftOneCount = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == '0') {
                leftZeroCount++;
            } else {
                leftOneCount++;
            }

            max = Math.max(max, leftZeroCount + oneCount - leftOneCount);
        }

        return max;
    }

}
