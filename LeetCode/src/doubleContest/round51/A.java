package doubleContest.round51;

/**
 * A
 *
 * @author: yry
 * @date: 2021/5/12
 */
public class A {

    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        for (int i = 1; i < len; i += 2) {
            arr[i] = (char) (arr[i - 1] + (arr[i] - '0'));
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
