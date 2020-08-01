package contest.contest199;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class B {

    public int minFlips(String target) {
        char[] arr = target.toCharArray();
        int len = arr.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            char cur = (char) ('0' + count % 2);
            if (cur == arr[i]) {
                continue;
            }

            count++;
        }

        return count;
    }

}
