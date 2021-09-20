package contest.contest243;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/30
 */
public class B {

    public String maxValue(String n, int x) {
        char[] arr = n.toCharArray();
        int len = arr.length;
        if (arr[0] == '-') {
            // 从左往右找第一个比他大的
            StringBuilder sb = new StringBuilder();
            boolean isFound = false;
            for (int i = 1; i < len; i++) {
                if (arr[i] - '0' > x) {
                    isFound = true;
                    sb.append(n.substring(0, i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    break;
                }
            }

            if (!isFound) {
                sb.append(n);
                sb.append(x);
            }

            return sb.toString();
        } else {
            // 从左往右找第一个比他小的
            StringBuilder sb = new StringBuilder();
            boolean isFound = false;
            for (int i = 0; i < len; i++) {
                if (arr[i] - '0' < x) {
                    isFound = true;
                    sb.append(n.substring(0, i));
                    sb.append(x);
                    sb.append(n.substring(i));
                    break;
                }
            }

            if (!isFound) {
                sb.append(n);
                sb.append(x);
            }

            return sb.toString();
        }
    }

}
