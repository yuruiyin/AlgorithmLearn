package problem001_100;

/**
 * PE009
 *
 * @author: yry
 * @date: 2020/3/27
 */
public class PE009 {

    // 判断是否完全平方数
    private boolean isOk(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    private int solve() {
        for (int a = 1; ;a++) {
            for (int b = a + 1; ;b++) {
                int value = a * a + b * b;
                if (a + b + Math.sqrt(value) > 1000) {
                    break;
                }

                if (isOk(value)) {
                    int c = (int) Math.sqrt(value);
                    if (a + b + c == 1000) {
                        return a * b * c;
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new PE009().solve());
    }
    
}
