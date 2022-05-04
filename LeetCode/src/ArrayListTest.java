import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {
        int[] arr = new int[(int) 1e8];
        for (int i = 0; i < 1e8; i++) {
            arr[i] = i * 3;
        }

        // for循环拷贝
        int[] arr1 = new int[(int) 1e8];
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1e8; i++) {
            arr1[i] = arr[i];
        }
        System.out.println("for 循环耗时：" + (System.currentTimeMillis() - start) + "ms");

        // clone
        start = System.currentTimeMillis();
        arr1 = arr.clone();
        System.out.println("clone 循环耗时：" + (System.currentTimeMillis() - start) + "ms");

        // System.arrayCopy
        start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, arr.length);
        System.out.println("System.arrayCopy 循环耗时：" + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(100000 - i);
        }
        Collections.sort(linkedList);
        System.out.println("LinkedList sort 耗时： " + (System.currentTimeMillis() - start) + "ms");
    }

}
