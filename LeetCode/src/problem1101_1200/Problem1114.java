package problem1101_1200;

/**
 * Problem1114
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem1114 {

    class Foo {

        private final Object lock = new Object();
        int flag = 0;

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (lock) {
                while (flag != 0) {
                    lock.wait();
                }
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                flag = 1;
                lock.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (lock) {
                while (flag != 1) {
                    lock.wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                flag = 2;
                lock.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (lock) {
                while (flag != 2) {
                    lock.wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                flag = 0;
                lock.notifyAll();
            }

        }
    }

}
