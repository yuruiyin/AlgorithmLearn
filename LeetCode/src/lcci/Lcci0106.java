package lcci;

public class Lcci0106 {

    public String compressString(String str) {
        if (str.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        int len = arr.length;
        sb.append(arr[0]);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                sb.append(count);
                sb.append(arr[i]);
                count = 1;
            }
        }

        sb.append(count);
        return sb.length() >= str.length() ? str : sb.toString();
    }

}
