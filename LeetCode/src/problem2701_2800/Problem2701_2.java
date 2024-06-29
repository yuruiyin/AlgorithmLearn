package problem2701_2800;

public class Problem2701_2 {

    public String removeTrailingZeros(String num) {
        char[] arr = num.toCharArray();
        int len = arr.length;
        while (len > 0 && arr[len - 1] == '0') {
            len--;
        }
        return num.substring(0, len);
    }

}
