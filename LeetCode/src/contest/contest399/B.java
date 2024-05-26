package contest.contest399;

public class B {

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] arr = word.toCharArray();
        int len =arr.length;
        int count = 1;
        char c = arr[0];
        for (int i = 1; i < len; i++) {
            if (count == 9) {
                sb.append(9).append(c);
                count = 1;
                c = arr[i];
                continue;
            }
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                sb.append(count).append(c);
                count = 1;
                c = arr[i];
            }
        }

        sb.append(count).append(c);

        return sb.toString();
    }

}
