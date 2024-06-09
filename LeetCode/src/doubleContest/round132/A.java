package doubleContest.round132;

public class A {

    public String clearDigits(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        boolean[] deleted = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(arr[i])) {
                deleted[i] = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (!Character.isDigit(arr[j]) && !deleted[j]) {
                        deleted[j] = true;
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (!deleted[i]) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
