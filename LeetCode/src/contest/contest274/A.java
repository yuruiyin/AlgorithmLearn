package contest.contest274;

/**
 * A
 *
 * @author: yry
 * @date: 2022/1/2
 */
public class A {

    public boolean checkString(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int bFirstIdx = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'b') {
                bFirstIdx = i;
                break;
            }
        }

        if (bFirstIdx == -1) {
            return true;
        }

        for (int i = len - 1; i >= bFirstIdx; i--) {
            if (arr[i] == 'a') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("hello world");

    }

}
