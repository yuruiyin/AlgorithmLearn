package problem1001_1100;

public class Problem1053 {

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;

        if (len == 1) {
            return arr;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                int max = arr[i+1];
                int maxIndex = i+1;
                for (int j = i + 2; j < len; j++) {
                    if (arr[j] < arr[i] && arr[j] > max) {
                        max = arr[j];
                        maxIndex = j;
                    }
                }
                swap(arr, i, maxIndex);
                break;
            }
        }

        return arr;
    }
    
    public static void main(String[] args) {
        
    }
    
}
