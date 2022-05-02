package contest.contest291;

public class A {

    public String removeDigit(String number, char digit) {
        char[] arr = number.toCharArray();
        int len = arr.length;
        int idx = -1;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] == digit && arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            if (idx == 0) {
                return number.substring(1);
            }
            return number.substring(0, idx) + number.substring(idx + 1);
        }

        if (arr[len - 1] == digit) {
            return number.substring(0, len - 1);
        }

        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] == digit) {
                idx = i;
                break;
            }
        }

        if (idx == 0) {
            return number.substring(1);
        }

        return number.substring(0, idx) + number.substring(idx + 1);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
