package contest.contest251;

/**
 * A
 *
 * @author: yry
 * @date: 2021/7/25
 */
public class A {

    public int getLucky(String s, int k) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c - 'a' + 1);
        }
        char[] arr1 = sb.toString().toCharArray();
        int ans = 0;
        while ((k--) > 0) {
            ans = 0;
            for (char c : arr1) {
                ans += (c - '0');
            }
            arr1 = (ans + "").toCharArray();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
