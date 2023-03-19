import java.util.Arrays;

/**
 * Test11
 *
 * @author: yry
 * @date: 2020/7/19
 */
public class Test11 {

    public Test11() {

    }

    public Test11(int age) {

    }

    public static void main(String[] args) {
//        boolean name = true;
//
//        if (name) {
//            System.out.println("yes");
//        }
//
//        if (true == name) {
//            System.out.println("no");
//        }
//
//        String[] arr = new String[]{"hello", "world"};
//        System.out.println(Arrays.toString(arr));

        int[] arr = new int[1_0000_0000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        long start = System.currentTimeMillis();
        long sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println(sum);
        System.out.println("java 耗时： " + (System.currentTimeMillis() - start) + "ms");
    }

}
