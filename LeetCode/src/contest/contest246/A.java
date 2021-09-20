package contest.contest246;

/**
 * A
 *
 * @author: yry
 * @date: 2021/6/20
 */
public class A {

    public String largestOddNumber(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        int end = -1;
        for (int i = len - 1; i >= 0; i--) {
            if ((arr[i] - '0') % 2 == 1) {
                end = i;
                break;
            }
        }

        if (end == -1) {
            return "";
        }

        return num.substring(0, end + 1);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }

}
