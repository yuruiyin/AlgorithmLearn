public class BitTest {

    private static final int MAX = 1000000000;

    private static void divide2() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (int i = 0; i < MAX; i++) {
            a = i;
            a /= 2;
        }
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println("除2 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void rightShift() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (int i = 0; i < MAX; i++) {
            a = i;
            a >>>= 1;
        }
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println("右移1位 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void multiply2() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (int i = 0; i < MAX; i++) {
            a = i;
            a *= 2;
        }
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println("乘2 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void leftShift() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (int i = 0; i < MAX; i++) {
            a = i;
            a <<= 1;
        }
        System.out.println(a);
        long end = System.currentTimeMillis();
        System.out.println("左移1位 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void xor() {
        long start = System.currentTimeMillis();
        int a = 1;
        int b = (1 << 10);
        for (int i = 0; i < MAX; i++) {
            a ^= b;
        }
        long end = System.currentTimeMillis();
        System.out.println("异或 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void or() {
        long start = System.currentTimeMillis();
        int a = 1;
        int b = (1 << 10);
        for (int i = 0; i < MAX; i++) {
            a |= b;
        }
        long end = System.currentTimeMillis();
        System.out.println("或 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void and() {
        long start = System.currentTimeMillis();
        int a = 1;
        int b = (1 << 10);
        for (int i = 0; i < MAX; i++) {
            a &= b;
        }
        long end = System.currentTimeMillis();
        System.out.println("与 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    private static void not() {
        long start = System.currentTimeMillis();
        int a = 1;
        for (int i = 0; i < MAX; i++) {
            a = ~a;
        }
        long end = System.currentTimeMillis();
        System.out.println("非 " + MAX + "次，耗时：" + (end - start) + "ms");
    }

    public static void main(String[] args) {

        xor();
        or();
        and();
        not();
        rightShift();
        divide2();
        leftShift();
        multiply2();
    }

}
