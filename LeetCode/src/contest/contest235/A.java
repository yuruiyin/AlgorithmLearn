package contest.contest235;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/4
 */
public class A {

    public String truncateSentence(String s, int k) {
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(str[i]);
            if (i < k - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
