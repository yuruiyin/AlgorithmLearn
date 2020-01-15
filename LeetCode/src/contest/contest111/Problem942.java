package contest.contest111;

public class Problem942 {

    public int[] diStringMatch(String str) {
        int len = str.length();
        char[] arr = str.toCharArray();
        int[] ans = new int[len + 1];
        int low = 0;
        int high = len;

        // 从两边往中间靠拢，遇到I，先用的是最小，遇到D先用最大。
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'I') {
                ans[index] = low;
                low++;
            } else {
                ans[index] = high;
                high--;
            }
            index++;
        }

        ans[index] = low;
        return ans;
    }

}
