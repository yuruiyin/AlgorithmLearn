package doubleContest.round24;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/18
 */
public class B {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);

        while (true) {
            int next = list.get(list.size() - 1) + list.get(list.size() - 2);
            if (next > 1e9) {
                break;
            }

            list.add(next);
        }

        int size = list.size();
        int ans = 0;
        int sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (sum + list.get(i) > k) {
                continue;
            }

            ans++;
            sum += list.get(i);
            if (sum == k) {
                return ans;
            }

            if (sum + list.get(i) == k) {
                ans++;
                return ans;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new B().findMinFibonacciNumbers(1000000000));
        System.out.println(new B().findMinFibonacciNumbers(513314));
    }
    

}
