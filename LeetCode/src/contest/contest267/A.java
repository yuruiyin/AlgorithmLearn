package contest.contest267;

import java.util.LinkedList;

/**
 * A
 *
 * @author: yry
 * @date: 2021/11/14
 */
public class A {

    class Data {
        int ticket;
        int idx;
        Data(int ticket, int idx) {
            this.ticket = ticket;
            this.idx = idx;
        }
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        LinkedList<Data> queue = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.add(new Data(tickets[i], i));
        }

        while (!queue.isEmpty()) {
            Data front = queue.pollFirst();
            if (front.idx == k) {
                if (front.ticket == 1) {
                    ans++;
                    break;
                } else {
                    queue.add(new Data(front.ticket - 1, k));
                }
            } else {
                if (front.ticket > 1) {
                    queue.add(new Data(front.ticket - 1, front.idx));
                }
            }
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
