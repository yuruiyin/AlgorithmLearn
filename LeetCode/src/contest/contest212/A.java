package contest.contest212;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/25
 */
public class A {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char[] arr = keysPressed.toCharArray();
        int len = arr.length;

        int max = releaseTimes[0];
        for (int i = 1; i < len; i++) {
            int dis = releaseTimes[i] - releaseTimes[i-1];
            if (dis > max) {
                max = dis;
            }
        }

        char maxChar = releaseTimes[0] == max ? arr[0] : 'a';
        for (int i = 1; i < len; i++) {
            int dis = releaseTimes[i] - releaseTimes[i-1];
            if (dis == max) {
                maxChar = (char) Math.max(maxChar, arr[i]);
            }
        }

        return maxChar;
    }

}
