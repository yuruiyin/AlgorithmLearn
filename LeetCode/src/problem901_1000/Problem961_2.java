package problem901_1000;

public class Problem961_2 {

    public int repeatedNTimes(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 2; i++) {
            if (arr[i] == arr[i+1] || arr[i] == arr[i+2]) {
                return arr[i];
            }
        }

        return arr[len - 1];
    }

}
