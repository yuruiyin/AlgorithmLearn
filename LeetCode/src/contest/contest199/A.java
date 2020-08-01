package contest.contest199;

/**
 * A
 *
 * @author: yry
 * @date: 2020/7/26
 */
public class A {

    public String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        char[] ansArr = new char[len];
        for (int i = 0; i < len; i++) {
            ansArr[indices[i]] = arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(ansArr[i]);
        }

        return sb.toString();
    }

}
