package doubleContest.round079;

public class A {

    public boolean digitCount(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        int[] countArr = new int[10];
        for (int i = 0; i < len; i++) {
            countArr[arr[i] - '0']++;
        }

        for (int i = 0; i < len; i++) {
            if (countArr[i] != (arr[i] - '0')) {
                return false;
            }
        }
        return true;
    }

}
