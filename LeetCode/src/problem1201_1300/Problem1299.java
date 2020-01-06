package problem1201_1300;

public class Problem1299 {

    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len-1];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }

        return arr;
    }
    
}
