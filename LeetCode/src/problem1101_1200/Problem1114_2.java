package problem1101_1200;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * Problem1114_2
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem1114_2 {

    class Foo {

        private Semaphore sp1;
        private Semaphore sp2;

        public Foo() {
            sp1 = new Semaphore(0);
            sp2 = new Semaphore(0);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            sp1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            sp1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            sp2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {
            sp2.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
