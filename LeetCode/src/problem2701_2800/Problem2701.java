package problem2701_2800;

public class Problem2701 {

    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder();
        char[] arr = num.toCharArray();
        int len = arr.length;
        boolean begin = false;
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] != '0') {
                begin = true;
            }
            if (begin) {
                sb.append(arr[i]);
            }
        }

        return sb.reverse().toString();
    }

}
