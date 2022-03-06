package contest.contest263;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2021/10/17
 */
public class A {

    public boolean areNumbersAscending(String s) {
        String[] arr = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            try {
                int num = Integer.parseInt(arr[i]);
                list.add(num);
            } catch (Exception e) {

            }
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
