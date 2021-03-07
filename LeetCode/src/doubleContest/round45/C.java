package doubleContest.round45;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/6
 */
public class C {

    public int minimumLength(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;

        int l = 0;
        int r = len - 1;
        while (l < r && arr[l] == arr[r]) {
            int i;
            for (i = l + 1; i < r; i++) {
                if (arr[i] != arr[l]) {
                    l = i;
                    break;
                }
            }

            if (i == r) {
                return 0;
            }

            for (i = r; i >= l; i--) {
                if (arr[i] != arr[r]) {
                    r = i;
                    break;
                }
            }
        }

        return r - l + 1;
    }

    public static void main(String[] args) {
        System.out.println(new C().minimumLength("cbc"));
    }

}
