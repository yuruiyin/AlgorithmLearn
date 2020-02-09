package contest.contest172;

public class Problem1323 {

    public int maximum69Number (int num) {
        char[] arr = String.valueOf(num).toCharArray();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }

        return Integer.parseInt(new String(arr));
    }

}
