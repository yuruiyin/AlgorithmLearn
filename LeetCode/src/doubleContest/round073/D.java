package doubleContest.round073;

public class D {

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int minMovesToMakePalindrome(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int ans = 0;
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
                continue;
            }
            // 取最近的
            int leftDis = Integer.MAX_VALUE;
            for (int i = l + 1; i < r; i++) {
                if (arr[i] == arr[r]) {
                    leftDis = i - l;
                    break;
                }
            }

            int rightDis = Integer.MAX_VALUE;
            for (int i = r - 1; i > l; i--) {
                if (arr[i] == arr[l]) {
                    rightDis = r - i;
                    break;
                }
            }

            if (leftDis <= rightDis) {
                for (int i = l + leftDis; i > l; i--) {
                    swap(arr, i, i - 1);
                }
                ans += leftDis;
            } else {
                for (int i = r - rightDis; i < r; i++) {
                    swap(arr, i, i + 1);
                }
                ans += rightDis;
            }
            l++;
            r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new D().minMovesToMakePalindrome("skwhhaaunskegmdtutlgtteunmuuludii"));
    }

}
