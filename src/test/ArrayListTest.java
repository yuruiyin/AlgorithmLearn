package test;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListTest
 *
 * @author: yry
 * @date: 2021/9/4
 */
public class ArrayListTest {

    private static final int MAX = (int) 1e8;

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < MAX; i++) {
//            list.add(i);
//        }
//
//        long start = System.currentTimeMillis();
//        list.add(100, (int) 1e9);
//        long end = System.currentTimeMillis();
//        System.out.println("list.add 耗时：" + (end - start) + "ms");

        int[] arr = new int[MAX + 1];
        for (int i = 0; i < 1e8; i++) {
            arr[i] = i;
        }

        long start = System.currentTimeMillis();

        for (int i = MAX; i > 100; i--) {
            arr[i] = arr[i - 1];
        }

//        System.arraycopy(arr, 100, arr, 101, MAX - 100);

        long end = System.currentTimeMillis();
        System.out.println("array add 耗时：" + (end - start) + "ms");
    }

}
