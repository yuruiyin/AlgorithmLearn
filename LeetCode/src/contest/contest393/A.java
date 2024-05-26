package contest.contest393;

public class A {

    public String findLatestTime(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 2) {
                continue;
            }

            if (arr[i] == '?') {
                if (i == 0) {
                    if (arr[i + 1] == '?') {
                        arr[i] = '1';
                        arr[i + 1] = '1';
                    } else if (arr[i + 1] > '1') {
                        arr[i] = '0';
                    } else {
                        arr[i] = '1';
                    }
                } else if (i == 1) {
                    if (arr[i - 1] == '0') {
                        arr[i] = '9';
                    } else {
                        arr[i] = '1';
                    }
                } else if (i == 3) {
                    arr[i] = '5';
                } else {
                    arr[i] = '9';
                }
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
