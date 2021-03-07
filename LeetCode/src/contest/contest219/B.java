package contest.contest219;

/**
 * A
 *
 * @author: yry
 * @date: 2020/12/13
 */
public class B {

    public int minPartitions(String n) {
        char[] arr = n.toCharArray();
        int max = 0;
        for (char c : arr) {
            max = Math.max(max, c - '0');
        }
        return max;
    }

}
