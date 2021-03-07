package contest.contest229;

/**
 * A
 *
 * @author: yry
 * @date: 2021/2/21
 */
public class B {

    public int[] minOperations(String boxes) {
        char[] arr = boxes.toCharArray();
        int len = arr.length;

        int[] ansArr = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[j] != '0') {
                    count += Math.abs(i - j);
                }
            }
            ansArr[i] = count;
        }

        return ansArr;
    }

    public static void main(String[] args) {
        int[] arr = new B().minOperations("110");
    }

}
