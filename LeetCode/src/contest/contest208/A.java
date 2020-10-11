package contest.contest208;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/27
 */
public class A {

    public int minOperations(String[] logs) {
        int cur = 0;
        for (String log : logs) {
            if (log.equals("./")) {
                continue;
            } else if (log.equals("../")) {
                cur = Math.max(0, cur - 1);
            } else {
                cur++;
            }
        }

        return cur;
    }

}
