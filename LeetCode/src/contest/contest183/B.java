package contest.contest183;

/**
 * A
 *
 * @author: yry
 * @date: 2020/4/5
 */
public class B {

    private char[] addOne(char[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == '0') {
                arr[i] = '1';
                return arr;
            } else {
                arr[i] = '0';
            }
        }
        char[] arr1 = new char[arr.length + 1];
        arr1[0] = '1';
        for (int i = 0; i < arr.length; i++) {
            arr1[i + 1] = arr[i];
        }
        return arr1;
    }

    private char[] divideTwo(char[] arr) {
        char[] ansArr = new char[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            ansArr[i] = arr[i];
        }
        return ansArr;
    }

    public int numSteps(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        while (arr.length > 1) {
            if (arr[arr.length - 1] == '0') {
                arr = divideTwo(arr);
            } else {
                arr = addOne(arr);
            }
            ans++;
        }

        return ans;
    }

}
