package problem901_1000;

public class Problem922 {

    public int[] sortArrayByParityII(int[] arr) {
        int len = arr.length;
        int[] oddArr = new int[len / 2];
        int[] evenArr = new int[len / 2];
        int indexOdd = 0;
        int indexEven = 0;

        for (int num : arr) {
            if (num % 2 == 1) {
                oddArr[indexOdd++] = num;
            } else {
                evenArr[indexEven++] = num;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i % 2 == 1) {
                arr[i] = oddArr[--indexOdd];
            } else {
                arr[i] = evenArr[--indexEven];
            }
        }

        return arr;
    }

}
