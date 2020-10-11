package fall_2020;

/**
 * A
 *
 * @author: yry
 * @date: 2020/9/12
 */
public class A {

    public int calculate(String s) {
//        "A" 运算：使 x = 2 * x + y；
//        "B" 运算：使 y = 2 * y + x。
        int x = 1;
        int y = 0;

        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == 'A') {
                x = 2 * x + y;
            } else {
                y = 2 * y + x;
            }
        }

        return x + y;
    }

}
