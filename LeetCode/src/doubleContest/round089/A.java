package doubleContest.round089;

public class A {

    public int countTime(String time) {
        int ans = 1;
        char[] arr = time.toCharArray();
        int len = arr.length;
        int left = 1;
        if (arr[0] == '?' && arr[1] == '?') {
            left = 24;
        } else if(arr[0] == '?') {
            if (arr[1] > '3') {
                left = 2;
            } else {
                left = 3;
            }
        } else if (arr[1] == '?') {
            if (arr[0] == '2') {
                left = 4;
            } else {
                left = 10;
            }
        }

        int right = 1;
        if (arr[3] == '?' && arr[4] == '?') {
            right = 60;
        } else if(arr[3] == '?') {
            right = 6;
        } else if (arr[4] == '?') {
            right = 10;
        }

        return left * right;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
