package contest.contest211;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/18
 */
public class A {

    public int maxLengthBetweenEqualCharacters(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int max = -1;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    max = Math.max(max, j - i - 1);
                }
            }
        }

        return max;
    }

}
