package doubleContest.round142;

public class  A {

    public int possibleStringCount(String word) {
        char[] arr = word.toCharArray();
        int len = arr.length;
        int count = 1;
        int ans = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                ans += count - 1;
                count = 1;
            }
        }

        ans += count - 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
