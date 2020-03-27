package test;

/**
 * StackOverflowTest
 *
 * @author: yry
 * @date: 2020/3/25
 */
public class StackOverflowTest {

    static class Task implements Runnable {

        private int rec(int n) {
            if (n == 1) {
                return 1;
            }
            return n + rec(n - 1);
        }

        @Override
        public void run() {
            System.out.println(rec(500000));
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Task(), "Thread-1", 1 << 26).start();
    }
    
}
