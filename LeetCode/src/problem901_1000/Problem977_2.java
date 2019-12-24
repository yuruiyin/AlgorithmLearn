package problem901_1000;

public class Problem977_2 {

    public int[] sortedSquares(int[] arr) {
        int len = arr.length;
        int[] ansArr = new int[len];
        int left = 0;
        int right = len - 1;
        int index = len;

        while (left <= right) {
            int squareLeft = arr[left] * arr[left];
            int squareRight = arr[right] * arr[right];
            if (squareLeft > squareRight) {
                ansArr[--index] = squareLeft;
                left++;
            } else {
                ansArr[--index] = squareRight;
                right--;
            }
        }

        return ansArr;
    }

}
