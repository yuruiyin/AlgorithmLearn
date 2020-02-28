package lcof;

public class Lcof066 {

    public int[] constructArr(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return new int[0];
        }

        int[] preMultiArr = new int[len];
        int[] sufMultiArr = new int[len];

        preMultiArr[0] = arr[0];
        for (int i = 1; i < len; i++) {
            preMultiArr[i] = preMultiArr[i-1] * arr[i];
        }

        sufMultiArr[len - 1] = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sufMultiArr[i] = sufMultiArr[i+1] * arr[i];
        }

        int[] ansArr = new int[len];
        ansArr[0] = len > 1 ? sufMultiArr[1] : 1;
        for (int i = 1; i < len - 1; i++) {
            ansArr[i] = preMultiArr[i-1] * sufMultiArr[i + 1];
        }
        ansArr[len - 1] = len > 1 ? preMultiArr[len - 2] : 1;

        return ansArr;
    }

}
