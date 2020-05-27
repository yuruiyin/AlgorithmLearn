package doubleContest.round25;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/2
 */
public class B {

    public int maxDiff(int num) {
        int maxDiff = 0;
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != '9') {
                char c = arr[i];
                for (int j = i; j < len; j++) {
                    if (arr[j] == c) {
                        arr[j] = '9';
                    }
                }
                break;
            }
        }

        int a = Integer.parseInt(new String(arr));

        char[] arr1 = String.valueOf(num).toCharArray();
        if (arr1[0] > '1') {
            char c = arr1[0];
            for (int i = 0; i < len; i++) {
                if (arr1[i] == c) {
                    arr1[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < len; i++) {
                if (arr1[i] != '0' && arr1[i] != '1') {
                    char c = arr1[i];
                    for (int j = i; j < len; j++) {
                        if (arr1[j] == c) {
                            arr1[j] = '0';
                        }
                    }
                    break;
                }
            }
        }

        int b = Integer.parseInt(new String(arr1));

        return a - b;
    }

    public static void main(String[] args) {
        System.out.println(new B().maxDiff(555));
    }

}
