
public class ForTest {

    private static final int N = 10000;

    private static long testForFor() {
        long ans = 0;
        for (int i = 0; i < 50000; i++) {
            for (int j = 0; j < 300; j++) {
                for (int k = 0; k < 20; k++) {
                    ans = ans % 2 == 0 ? i : i + 1;
                }
            }
        }
        return ans;
    }

    private static long testForFor1() {
        long ans = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 300; j++) {
                for (int k = 0; k < 50000; k++) {
                    ans = ans % 2 == 0 ? k : k + 1;
                }
            }
        }
        return ans;
    }

    private static long testForWithRec() {
        long ans = 0;
        for (int i = 0; i < 20; i++) {
            ans += getCount();
        }
        return ans;
    }

    private static long getCount() {
        long ans = 0;
        for (int j = 0; j < 300; j++) {
            for (int k = 0; k < 50000; k++) {
                ans = ans % 2 == 0 ? k : k + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        long start = System.currentTimeMillis();

        long ans = testForFor();
        System.out.println(ans);
        System.out.println("三重循环（循环次数少放里面）耗时: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        long ans1 = testForFor1();
        System.out.println(ans1);
        System.out.println("三重循环（循环次数少放里面）耗时: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        long ans2 = testForWithRec();
        System.out.println(ans2);
        System.out.println("一重+调用函数耗时: " + (System.currentTimeMillis() - start) + "ms");
    }

}
