package problem1101_1200;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Problem1114_3
 *
 * @author: yry
 * @date: 2020/4/2
 */
public class Problem1114_3 {

    class Foo {

        private ReentrantLock lock;
        private Condition condition1;
        private Condition condition2;
        private int flag = 0;

        public Foo() {
            lock = new ReentrantLock();
            condition1 = lock.newCondition();
            condition2 = lock.newCondition();
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            printFirst.run();
            flag = 1;
            condition1.signalAll();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            if (flag != 1) {
                condition1.await();
            }
            printSecond.run();
            flag = 2;
            condition2.signalAll();
            lock.unlock();
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            if (flag != 2) {
                condition2.await();
            }
            printThird.run();
            lock.unlock();
        }
    }

}
