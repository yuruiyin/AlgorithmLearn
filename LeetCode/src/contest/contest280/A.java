package contest.contest280;

/**
 * A
 *
 * @author: yry
 * @date: 2022/2/13
 */
public class A {

    public int countOperations(int num1, int num2) {
        int ans = 0;
        while (num1 > 0 && num2 > 0) {
            if (num1 >= num2) {
                num1 = num1 - num2;
            } else  {
                num2 = num2 - num1;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
