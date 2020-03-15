package utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Test11
 *
 * @author: yry
 * @date: 2020/3/15
 */
public class Test11 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()) {
//            int num = iterator.next();
//            if (num == 2) {
//                iterator.remove();
//            }
//            System.out.println(num);
//        }



        for (Integer num : set) {
            if (num == 2) {
                set.remove(2);
            }
            System.out.println(num);
        }

        for (Integer num : set) {
            System.out.println(num);
        }
    }

}
