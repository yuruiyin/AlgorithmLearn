package contest.contest263;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/17
 */
public class B {

    class Bank {

        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if (account1 > balance.length || account2 > balance.length) {
                return false;
            }
            if (money > balance[account1 - 1]) {
                return false;
            }
            balance[account1 - 1] -= money;
            balance[account2 - 1] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            if (account > balance.length) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            if (account > balance.length) {
                return false;
            }
            if (money > balance[account - 1]) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }
    }


}
