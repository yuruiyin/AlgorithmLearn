package contest.contest253;

/**
 * A
 *
 * @author: yry
 * @date: 2021/8/8
 */
public class C {

    private void swap(char[] arr, int i, int j) {
        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public int minSwaps(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int l = 0;
        int r = len - 1;
        int leftCount = 0;
        int ans = 0;
        while (l < r) {
            if (arr[l] == ']') {
                if (leftCount < l + 1 - leftCount) {
                    for (int i = r; i > l; i--) {
                        if (arr[i] == '[') {
                            ans++;
                            r = i - 1;
                            leftCount++;
                            swap(arr, i, l);
                            break;
                        }
                    }
                }
            } else {
                leftCount++;
            }
            l++;
        }

        return ans;
    }

}
