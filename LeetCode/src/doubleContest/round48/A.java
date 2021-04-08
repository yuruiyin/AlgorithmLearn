package doubleContest.round48;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/3/20
 */
public class A {

    public int secondHighest(String s) {
        char[] arr = s.toCharArray();
        TreeSet<Integer> list = new TreeSet<>();
        for (char c : arr) {
            if (c >= '0' && c <= '9') {
                list.add(c - '0');
            }
        }

        if (list.size() <= 1) {
            return -1;
        }

        list.pollLast();
        return list.last();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
