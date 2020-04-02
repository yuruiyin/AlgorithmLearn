package problem301_400;

/**
 * Problem390 OOM
 *
 * @author: yry
 * @date: 2020/4/1
 */
public class Problem390 {

    public int lastRemaining(int n) {
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            arr[i-1] = i;
        }

        boolean isFromLeft = true;
        int size = n;

        while (size > 1) {
            int nextSize = size >>> 1;
            if (isFromLeft) {
                for (int i = 0; i < nextSize; i++) {
                    arr[i] = arr[i * 2 + 1];
                }
            } else {
                if ((size & 1) == 1) {
                    for (int i = 0; i < nextSize; i++) {
                        arr[i] = arr[i * 2 + 1];
                    }
                } else {
                    for (int i = 0; i < nextSize; i++) {
                        arr[i] = arr[i * 2];
                    }
                }
            }

            size = nextSize;
            isFromLeft = !isFromLeft;
        }

        return arr[0];
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem390().lastRemaining(9));
    }

}
