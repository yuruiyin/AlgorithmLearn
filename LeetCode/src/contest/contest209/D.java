package contest.contest209;

/**
 * A
 *
 * @author: yry
 * @date: 2020/10/4
 */
public class D {

    private boolean isLowBitsAllZero(int n, int zeroCount) {
        return (n & ((1 << zeroCount) - 1)) == 0;
    }

    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int ansCount = 0;
        char[] arr = Integer.toBinaryString(n).toCharArray();
        int len = arr.length;
        if (arr[1] == '1' && (len == 2 || isLowBitsAllZero(n, len - 2))) {
            ansCount = 1 + minimumOneBitOperations(n ^ (1 << (len - 1)));
        } else if (arr[1] == '0') {
            if (len == 2) {
                ansCount = 1 + minimumOneBitOperations(3);
            } else {
                int right = len == 3 ? 0 : (n & ((1 << (len - 3)) - 1));
                int nextN = (1 << (len - 1)) + (1 << (len - 2)) + (1 << (len - 3));
                ansCount = 1 + Math.abs(arr[2] - '1') + minimumOneBitOperations(right) + minimumOneBitOperations(nextN);
            }
        } else {
            int nextN = 1 << (len - 2);
            ansCount = 1 +  minimumOneBitOperations(n & ((1 << (len - 2)) - 1)) + minimumOneBitOperations(nextN);
        }

        return ansCount;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(14));
//        System.out.println(new D().minimumOneBitOperations(333));
        System.out.println(new D().minimumOneBitOperations(5));
    }

}
