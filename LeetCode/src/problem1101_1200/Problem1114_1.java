package problem1101_1200;

import java.util.concurrent.CountDownLatch;

/**
 * Problem1114_1
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem1114_1 {

    class Foo {

        private CountDownLatch countDownLatch1;
        private CountDownLatch countDownLatch2;

        public Foo() {
            countDownLatch1 = new CountDownLatch(1);
            countDownLatch2 = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            countDownLatch1.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            countDownLatch1.await();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            countDownLatch2.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            countDownLatch2.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

}
