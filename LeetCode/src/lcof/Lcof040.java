package lcof;

import java.util.Arrays;

public class Lcof040 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

}
