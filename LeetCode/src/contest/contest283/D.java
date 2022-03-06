package contest.contest283;

import java.util.*;

/**
 * D
 *
 * @author: yry
 * @date: 2022/3/6
 */
public class D {

    private int calcGcd(int m, int n) {
        return m % n == 0 ? n : calcGcd(n, m % n);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int num : nums) {
            int x = num;
            while (stack.size() > 0) {
                int top = stack.peekLast();
                int gcd = calcGcd(top, x);
                if (gcd == 1) {
                    break;
                }

                x = top / gcd * x;
                stack.pollLast();
            }
            stack.addLast(x);
        }

        return new ArrayList<>(stack);
    }

    public static void main(String[] args) {
        System.out.println(new D().replaceNonCoprimes(new int[]{287,41,49,287,899,23,23,20677,5,825}));
    }

}
