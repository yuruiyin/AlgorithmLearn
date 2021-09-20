package contest.contest251;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/25
 */
public class B {

    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (change[arr[i] - '0'] > arr[i] - '0') {
                arr[i] = (char) (change[arr[i] - '0'] + '0');
                for (int j = i + 1; j < len; j++) {
                    if (change[arr[j] - '0'] < arr[j] - '0') {
                        break;
                    }
                    arr[j] = (char) (change[arr[j] - '0'] + '0');
                }
                return new String(arr);
            }
        }
        return new String(arr);
    }

}
